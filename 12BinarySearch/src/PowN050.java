import org.junit.Test;

/**
 * 实现pow(x, n)，即计算 x 的 n 次幂函数（即，xn）。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * <p>
 * 提示：
 * <p>
 * -100.0 <x< 100.0
 * -231<= n <=231-1
 * -104 <= xn <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 03-27-2021 23:13
 */
public class PowN050 {

    /**
     * 使用折半计算，每次把n缩小一半，这样n最终会缩小到0，任何数的0次方都为1，这时候我们再往回乘，
     * 如果此时n是偶数，直接把上次递归得到的值算个平方返回即可，如果是奇数，则还需要乘上个x的值。
     * 还有一点需要引起我们的注意的是n有可能为负数，对于n是负数的情况，我们可以先用其绝对值计算出一个结果再取其倒数即可。
     * 我们让i初始化为n，然后看i是否是2的倍数，是的话x乘以自己，否则res乘以x，i每次循环缩小一半，直到为0停止循环。
     * 最后看n的正负，如果为负，返回其倒数。
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            int tmp = i % 2;
            if (tmp != 0) {
                // 奇数额外再乘一次
                res = res * x;
            }
            x = x * x;
        }
        // 对负数处理
        return n < 0 ? 1 / res : res;
    }


    @Test
    public void myPowTest() {
        double x = 2;
        int n = 4;
        System.out.println(myPow(x, n));
    }

}
