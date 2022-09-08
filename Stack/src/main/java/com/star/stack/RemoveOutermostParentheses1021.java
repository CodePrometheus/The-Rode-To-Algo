package com.star.stack;

import org.junit.Test;

/**
 * 有效括号字符串为空("")、"(" + A + ")"或A + B，其中A 和B都是有效的括号字符串，+代表字符串的连接。例如，""，"()"，"(())()"和"(()(()))"都是有效的括号字符串。
 * <p>
 * 如果有效字符串S非空，且不存在将其拆分为S = A+B的方法，我们称其为原语（primitive），其中A 和B都是非空有效括号字符串。
 * <p>
 * 给出一个非空有效字符串S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中P_i是有效括号字符串原语。
 * <p>
 * 对S进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S。
 *
 * @Author: zzStar
 * @Date: 02-21-2021 23:01
 */
public class RemoveOutermostParentheses1021 {

    /**
     * 这道题可以用栈来找出所有原语分解，然后对每个分解后的去除最左边和最右边的括号最后连在一起即可，但是这种复杂度较高。
     * 由于题中说了S一定是合法的，我们就可以用统计左括号的个数的方法直接过滤掉每个原语的最外层括号。
     */
    public String removeOuterParentheses(String S) {

        int left = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            // 从下标2开始
            if (S.charAt(i) == '(' && left++ > 0) {
                res.append('(');
            }
            if (S.charAt(i) == ')' && --left > 0) {
                res.append(')');
            }
        }
        return res.toString();
    }

    /**
     * 由于字符串肯定以(开始，所以第一个(必然需要过滤，所以先if (')' == c) level--;
     * 2.由于才开始过滤了(，所以第一个有效字符串结束后level为-1，
     * 第二个有效字符以(开始，也需要过滤，所以才会在level >= 1时 append
     */
    public String removeOuterParentheses2(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') {
                --level;
            }
            if (level >= 1) {
                sb.append(c);
            }
            if (c == '(') {
                ++level;
            }
        }
        return sb.toString();
    }

    @Test
    public void removeOuterParenthesesTest() {
        String s = "(()()((";
        System.out.println(removeOuterParentheses(s));
        System.out.println(removeOuterParentheses2(s));
    }
}
