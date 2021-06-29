import org.junit.Test;

/**
 * @Author: zzStar
 * @Date: 05-02-2021 13:24
 */
public class SplitString5747 {

    char[] num;
    int n;

    public boolean splitString(String s) {
        n = s.length();
        num = s.toCharArray();
        return dfs(0, 0, 0);
    }

    private boolean dfs(int index, long pre, int cnt) {
        if (index == n) {
            return cnt > 1;
        }
        long cur = 0;
        for (int i = index; i < n; i++) {
            cur = cur * 10 + num[i] - '0';
            if (cnt == 0 || cur == pre - 1) {
                if (dfs(i + 1, cur, cnt + 1)) {
                    return true;
                }
            }
        }
        return false;
    }


    @Test
    public void splitStringTest() {
        String s = "050043";
        System.out.println(splitString(s));
    }
}
