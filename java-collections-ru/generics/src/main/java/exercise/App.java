package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    static boolean containsAllEntries(Map<?, ?> map1, Map<?, ?> map2) {
        return map1.entrySet().containsAll(map2.entrySet());
    }

    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Map elem : books) {
            if (containsAllEntries(elem, where)) {
                result.add(elem);
            }
        }
        return result;
    }
}
//END
