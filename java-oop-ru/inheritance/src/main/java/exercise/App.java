package exercise;

import java.util.Map;

public class App {
    public static void main(String[] args) {
//        Tag img = new SingleTag("img", Map.of("class", "v-10", "id", "wop"));
//        System.out.println(img.toString());
        Map<String, String> map = Map.of("class", "v-10", "id", "wop");
        for (Map.Entry<String, String> m : map.entrySet()) {
            System.out.println(m);
        }
    }
}
