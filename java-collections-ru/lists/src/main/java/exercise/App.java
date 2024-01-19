package exercise;

//import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
//import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        char[] w = word.toLowerCase().toCharArray();
        int index = 0;
    //        for (char i: w) {
    //            System.out.println(i);
    //        }

        List<Character> chars = new ArrayList<>();
        for (char c : symbols.toCharArray()) {
            chars.add(c);
        }
        //System.out.println(chars.get(0));
        for (char i: w) {
            if (chars.contains(i)) {
    //                System.out.println(chars.toString());
    //                System.out.println(i);
                index = chars.indexOf(i);
                chars.remove(index);
    //                System.out.println(chars.toString());
                continue;
            } else {
    //              System.out.println("false");
                return false;
            }
        }
    //        System.out.println("true");
        return true;
    }
}

//END
