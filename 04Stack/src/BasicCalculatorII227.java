import java.util.Stack;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 * <p>
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 03-11-2021 22:44
 */
public class BasicCalculatorII227 {

    /**
     *
     */
    public int calculate(String s) {
        // 保存上一个符号，初始为 +
        char sign = '+';
        Stack<Integer> numStack = new Stack<>();
        // 保存当前数字，如：12是两个字符，需要进位累加
        int num = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= '0') {
                // 记录当前数字。先减，防溢出
                num = num * 10 - '0' + cur;
            }
            if ((cur < '0' && cur != ' ') || i == s.length() - 1) {
                // 判断上一个符号是什么
                switch (sign) {
                    // 当前符号前的数字直接压栈
                    case '+':
                        numStack.push(num);
                        break;
                    // 当前符号前的数字取反压栈
                    case '-':
                        numStack.push(-num);
                        break;
                    // 数字栈栈顶数字出栈，与当前符号前的数字相乘，结果值压栈
                    case '*':
                        numStack.push(numStack.pop() * num);
                        break;
                    // 数字栈栈顶数字出栈，除于当前符号前的数字，结果值压栈
                    case '/':
                        numStack.push(numStack.pop() / num);
                        break;
                }
                // 记录当前符号
                sign = cur;
                // 数字清零
                num = 0;
            }
        }
        // 将栈内剩余数字累加，即为结果
        while (!numStack.isEmpty()) {
            result += numStack.pop();
        }
        return result;
    }


    /**
     * 建立一个单栈来存储和更新乘除运算后的数，用一个字符变量表示op乘除符号。用sign=1或-1来表示加减符号。
     * 还是记住几个关键点：
     * 1.空格直接放过；
     * 2.遇到加减运算符，st_num才出栈，并且更新ans和sign
     * 3.遇到数字，先找完，再进栈，如果在它之前有乘除符号（也就是op不为‘#’），那么就要和弹出栈的数字做乘除运算更新它，在乘除运算完之后，才能入栈，然后op重置
     *
     * @param s
     * @return
     */
    public int calculate2(String s) {
        int len = s.length();
        char[] str = s.toCharArray();
        Stack<Integer> st_num = new Stack<>();
        // 记录乘除符号
        char op = '#';
        // 记录加减符号
        int ans = 0, sign = 1;
        for (int i = 0; i < len; i++) {
            if (str[i] == ' ') {
                continue;
            }
            if (str[i] >= '0' && str[i] <= '9') {
                int num = str[i] - '0';
                // 找完这个数
                while (i < len - 1 && str[i + 1] >= '0' && str[i] <= '9') {
                    num = num * 10 + (str[++i] - '0');
                }
                //如果之前有乘除符号
                if (op != '#') {
                    if (op == '*') {
                        // 则将这个数运算之后，再重新进栈
                        num *= st_num.pop();
                    } else {
                        num = st_num.pop() / num;
                    }
                    // 重置乘除符号
                    op = '#';
                }
                st_num.push(num);
            } else if (str[i] == '*' || str[i] == '/') {
                // 更新乘除符号
                op = str[i];
            } else {
                // 遇到加减符号则可以直接更新ans了
                ans += st_num.pop() * sign;
                // 更新加减符号
                sign = str[i] == '+' ? 1 : -1;
            }
        }
        // sign更新后，还有一次未计算
        return ans + st_num.pop() * sign;
    }
}
