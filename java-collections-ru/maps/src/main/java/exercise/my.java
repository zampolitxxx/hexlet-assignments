package exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class my {
    public static void main(String[] args) {
        String sentence1 = "";
        Map y = getWordCount(sentence1);
        System.out.println(y);
        String res = toString(y);
        System.out.println(res);
    }
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
        String result = "{\n";
        for(String k: setKeys){
            result = result + "  " + k + ": " + map.get(k) + "\n";
        }
        result = result + "}";

        return result;
    }

}
