import org.junit.Test;

/**
 * 以字符串作为输入，反转该字符串中的元音字母。
 *
 * @Author: zzStar
 * @Date: 02-17-2021 23:53
 */
public class ReverseVowelsOfAString345 {

    public String reverseVowels(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char temp;
        char[] str = s.toCharArray();
        String letter = "aeiouAEIOU";
        int i = 0, j = s.length() - 1;
        while (i < j) {
            // 存在元音
            if (letter.indexOf(str[i]) != -1 && letter.indexOf(str[j]) != -1) {
                temp = str[i];
                str[i] = str[j];
                str[j] = temp;
                i++;
                j--;
            } else if (letter.indexOf(str[i]) != -1) {
                j--;
            } else if (letter.indexOf(str[j]) != -1) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return new String(str);
    }

    @Test
    public void ReverseVowelsTest() {
        String s = "hello";
        System.out.println(reverseVowels(s));
    }
}
