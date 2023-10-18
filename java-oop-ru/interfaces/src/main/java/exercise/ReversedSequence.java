package exercise;
import java.lang.CharSequence;
import java.lang.reflect.Array;
import java.lang.StringBuilder;

// BEGIN
    public class ReversedSequence implements CharSequence {
        StringBuilder sb;

        public ReversedSequence(String str) {
            this.sb = new StringBuilder(str);
        }

        public String toString() {
            return sb.reverse().toString();
        }

        @Override
        public int length() {
        return sb.length();
        }

        @Override
        public char charAt(int index) {
        return sb.charAt(index);
        }

        @Override
        public CharSequence subSequence(int start, int end) {
        return sb.reverse().subSequence(start, end);
        }
}
// END
