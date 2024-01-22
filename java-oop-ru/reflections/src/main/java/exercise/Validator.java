package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> result = new ArrayList<>();
        try {
            var fields = address.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(NotNull.class)) {
                    field.setAccessible(true);
                    var value = field.get(address);
                    if (value == null) {
                        result.add(field.getName());
                    }
                }
            }
        } catch (IllegalAccessException | NullPointerException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) throws IllegalAccessException {
        Map<String, List<String>> result = new HashMap<>();
        var fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class) | field.isAnnotationPresent(MinLength.class)) {
                String key = field.getName();
                List<String> errors = getErrorsForField(field, address);
                if (!errors.isEmpty()) {
                    result.put(key, errors);
                }
            }
        }
        return result;
    }

    public static List<String> getErrorsForField (Field field, Address address) {
        List<String> listOfErrors = new ArrayList<>();
        try {
            field.setAccessible(true);
            String value = (String) field.get(address);
            if(field.isAnnotationPresent(NotNull.class) & value == null) {
                listOfErrors.add("can not be null");
            } else if (field.isAnnotationPresent(MinLength.class)) {
                int minLength = field.getAnnotation(MinLength.class).minLength();
                if (value == null | value.length() < minLength) {
                    listOfErrors.add("length less than " + minLength);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return listOfErrors;
    }
}
// END
