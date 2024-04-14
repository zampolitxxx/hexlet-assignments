package exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String file1, String file2, String file_result) {

        CompletableFuture<String> string1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("First file read");
                TimeUnit.SECONDS.sleep(5);
                return Files.readString(Paths.get(file1).toAbsolutePath().normalize());
            } catch (IOException | InterruptedException e) {
                System.out.println("First file not found");
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<String> string2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Second file read");
                TimeUnit.SECONDS.sleep(5);
                return Files.readString(Paths.get(file2).toAbsolutePath().normalize());
            } catch (IOException | InterruptedException e) {
                System.out.println("Second file not found");
                throw new RuntimeException(e);
            }
        });

        return string1.thenCombine(string2, (f1, f2) -> {
            try {
                if (Files.notExists(Paths.get(file_result).toAbsolutePath().normalize())) {
                    System.out.println("Result file create");
                    Files.createFile(Paths.get(file_result).toAbsolutePath().normalize());
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter(file_result));
                writer.write(f1);
                writer.write(f2);
                writer.close();
                System.out.println("Writing to result file completed");
                TimeUnit.SECONDS.sleep(5);
            } catch (IOException | InterruptedException e) {
                System.out.println("Result file not found");
                throw new RuntimeException(e);
            }
            String result = f1 + f2;
            System.out.println("Sum of files=" + result);
            return result;
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return null;
        });
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> result = App.unionFiles("src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/file3.txt");
        System.out.println("Result= " + result.toString());
        // END
    }
}

