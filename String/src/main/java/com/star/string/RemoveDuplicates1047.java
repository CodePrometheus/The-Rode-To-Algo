package com.star.string;

import org.junit.Test;

/**
 * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 *
 * <p>
 * 示例：
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 03-09-2021 22:48
 */
public class RemoveDuplicates1047 {

    /**
     * 充分理解题意后，我们可以发现，当字符串中同时有多组相邻重复项时，我们无论是先删除哪一个，都不会影响最终的结果。
     * 因此我们可以从左向右顺次处理该字符串。
     * 而消除一对相邻重复项可能会导致新的相邻重复项出现，如从字符串 abba 中删除 bb 会导致出现新的相邻重复项 aa 出现。
     * 因此我们需要保存当前还未被删除的字符。一种显而易见的数据结构呼之欲出：栈。
     * 我们只需要遍历该字符串，如果当前字符和栈顶字符相同，我们就贪心地将其消去，否则就将其入栈即可。
     */
    public String removeDuplicates(String S) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }

    /**
     * 双指针
     *
     * @param S
     * @return
     */
    public String removeDuplicates2(String S) {
        char[] s = S.toCharArray();
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            if (top == -1 || s[top] != s[i]) {
                s[++top] = s[i];
            } else {
                top--;
            }
        }
        return String.valueOf(s, 0, top + 1);
    }

    public String removeDuplicates3(String S) {
        int left = 0;
        int right = 0;
        int length = S.length();
        char[] chars = S.toCharArray();
        while (right < length) {
            //先把右边的字符赋值给左边
            chars[left] = chars[right];
            //然后判断左边挨着的两个字符是否相同，如果相同，
            //他两同时消失，也就是left往回退两步
            if (left > 0 && chars[left - 1] == chars[left]) {
                left -= 2;
            }
            ++right;
            ++left;
        }
        return new String(chars, 0, left);
    }

    @Test
    public void removeDuplicatesTest() {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
        System.out.println(removeDuplicates2(s));
        System.out.println(removeDuplicates3(s));
    }
}
