import org.junit.Test;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 * <p>
 * 输入：x = -101
 * 输出：false
 *
 * <p>
 * 提示：
 * <p>
 * -231<= x <= 231- 1
 *
 * <p>
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 03-19-2021 22:42
 */
public class PalindromeNumber009 {

    /**
     * 反转一半数字
     */
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        // 因为首位不可能为0
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int revert = 0;
        /**一边给原数字不断除以10，一边从后往前计算revert*/
        while (x > revert) {
            revert = revert * 10 + x % 10;
            x /= 10;
        }
        // 偶数则两者相等，奇数个则去掉revert的最后一位数
        return x == revert || x == revert / 10;
    }

    /**
     * 整数转为字符串
     * 然后将字符串分割为数组，只需要循环数组的一半长度进行判断对应元素是否相等即可
     */
    public boolean isPalindrome2(int x) {
        String reverserString = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reverserString);
    }

    /**
     * 同时比较首位和末位
     */
    public boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        // 算出div的值，针对首位进行取数
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    @Test
    public void isPalindromeTest() {
        int n = 10201;
        System.out.println(isPalindrome(n));
        System.out.println(isPalindrome2(n));
        System.out.println(isPalindrome3(n));
    }
}
