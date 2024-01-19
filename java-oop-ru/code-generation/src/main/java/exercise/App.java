package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.io.IOException;


// BEGIN
public class App {
    public static void save(Path path, Car item) throws IOException {

        String json = item.serialize();
        Files.write(path, Collections.singleton(json), StandardCharsets.UTF_8);
    }

    public static Car extract(Path path) {

        Path fullPath = path.toAbsolutePath().normalize();
        try {
            String strForInstantiation = Files.readString(fullPath);
            Car result = Car.unserialize(strForInstantiation);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
// END
