package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        KeyValueStorage k = new FileKV("src/test/resources/file", Map.of("key1", "value1", "key2", "value2"));
//        k.set("key1", "value3");
//        k.set("key4", "value4");
        k.unset("key1");
        System.out.println(k.toMap());
    }
}

//    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();
//
//    @BeforeEach
//    public void beforeEach() throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
//        String content = mapper.writeValueAsString(new HashMap<String, String>());
//        Files.writeString(filepath, content, StandardOpenOption.CREATE);
//    }