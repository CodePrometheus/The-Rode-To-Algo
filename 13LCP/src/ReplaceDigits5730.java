import org.junit.Test;

/**
 * @Author: zzStar
 * @Date: 05-02-2021 09:20
 */
public class ReplaceDigits5730 {

    public String replaceDigits(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2) {
            if (i + 1 < s.length()) {
                array[i + 1] = (char) (array[i + 1] + (array[i] - '0'));
            }
        }
        return String.valueOf(array);
    }

    @Test
    public void replaceDigitsTest() {
        String s = "a1b2";
        System.out.println(replaceDigits(s));
    }
}
