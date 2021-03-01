import org.junit.Test;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * @Author: zzStar
 * @Date: 02-12-2021 22:40
 */
public class FibonacciNumber509 {

    /**
     * 递归 效率低
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        // F(n) = F(n - 1) + F(n - 2)
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 动态规划
     */
    public int fib2(int n) {
        if (n < 2) {
            return n;
        }
        // 只要记录前两个状态，所以可以优化成常数空间
        int a = 0, b = 1, c;
        // n>=3
        while (n-- > 1) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    @Test
    public void fibTest() {
        int n = 3;
        System.out.println(fib(3));
        System.out.println(fib2(3));
    }
}
