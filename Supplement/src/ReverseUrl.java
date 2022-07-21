import java.util.Arrays;

/**
 * 翻转URL字符串里的单词
 * www.bytedance.com -> com.bytedance.www
 *
 * @Author: zzStar
 * @Date: 07-21-2022
 */
public class ReverseUrl {

    public static String allRotate(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int left = 0;
        // 先局部反转
        for (int i = 0; i < n; i++) {
            if (chars[i] == '.') {
                rotate(chars, left, i - 1);
                left = i + 1;
            }
        }
        rotate(chars, left, n - 1);
        rotate(chars, 0, n - 1);
        return new String(chars);
    }

    public static void rotate(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String str = "www.baidu.com";
        System.out.println(allRotate(str));
    }

}
