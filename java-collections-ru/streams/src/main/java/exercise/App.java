package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        long amount=0;
        if (emails != null) {
            amount = emails.stream()
                    .filter(email ->email.endsWith("gmail.com") || email.endsWith("yandex.ru") || email.endsWith("hotmail.com"))
                    .count();
        }
        return amount;
    }

}
// END
