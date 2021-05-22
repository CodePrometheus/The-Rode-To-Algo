import org.junit.Test;

/**
 * 给定一个非负整数c，你要判断是否存在两个整数 a 和 b，使得a2 + b2 = c 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 * <p>
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：c = 1
 * 输出：true
 *
 * <p>
 * 提示：
 * <p>
 * 0 <= c <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 04-28-2021 14:07
 */
public class JudgeSquareSum633 {

    /**
     * 枚举
     * a 和 b 的范围均为 [0,根号c]
     */
    public boolean judgeSquareSum(int c) {
        int max = (int) Math.sqrt(c);
        for (int a = 0; a <= max; a++) {
            int b = (int) Math.sqrt(c - a * a);
            if (a * a + b * b == c) {
                return true;
            }
        }
        return false;
    }

    /**
     * 双指针
     * 由于 a 和 b 的范围均为 [0,根号c]
     * a2 +b2 ==c : 找到符合条件的 a 和 b，返回 true
     * <c a--
     * >c b--
     */
    public boolean judgeSquareSum2(int c) {
        int a = 0, b = (int) Math.sqrt(c);
        while (a <= b) {
            int cur = a * a + b * b;
            if (cur == c) {
                return true;
            } else if (cur > c) {
                b--;
            } else {
                a++;
            }
        }
        return false;
    }

    @Test
    public void judgeSquareSumTest() {

    }
}
