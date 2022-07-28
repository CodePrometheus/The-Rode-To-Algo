/**
 * @Author: zzStar
 * @Date: 06-04-2022 21:45
 */
public class rearrange2287 {
    public static void main(String[] args) {
        rearrange2287 r = new rearrange2287();
        r.shortestPalindrome("aacecaaa");
    }
    public String shortestPalindrome(String s) {
        char[] c = s.toCharArray();
        int l = 0, r = c.length - 1, t = r;
        while (l < t) {
            if (c[l] != c[t]) {
                l = 0;
                r--;
                t = r;
            } else {
                l++;
                t--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = c.length - 1; i > r; i--) {
            sb.append(c[i]);
        }
        return sb.append(s).toString();
    }
}
