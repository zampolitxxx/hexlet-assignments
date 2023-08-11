package exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// BEGIN
class App {
    public static Map getWordCount(String sentence) {
        Map<String, Integer> map = new HashMap<>();
        if (sentence.isEmpty()) {
            return map;
        }
        String[] words = sentence.split(" ");
        for (String s : words) {
            if (map.containsKey(s)) {
                int value = map.get(s);
                value++;
                map.put(s,value);
            } else {
                map.put(s, 1);
            }
        }
        return map;
    }

    public static String toString(Map map) {
        Set<String> setKeys = map.keySet();
        String result = "{";
        if (!map.isEmpty()) {
            result = result + "\n";
        }
        for(String k: setKeys){
            result = result + "  " + k + ": " + map.get(k) + "\n";
        }
        result = result + "}";
        return result;
    }
}
//END
