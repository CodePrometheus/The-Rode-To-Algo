import org.junit.Test;

/**
 * 给你两个字符串，请你从这两个字符串中找出最长的特殊序列。
 * <p>
 * 「最长特殊序列」定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 * <p>
 * 子序列 可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 * <p>
 * 输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1
 *
 * @Author: zzStar
 * @Date: 02-20-2021 23:27
 */
public class LongestUncommonSubsequenceI521 {

    /**
     * s1 = 'ab',s2 = 'a',因为ab是s1独有，所以最长子序列为ab，
     * s1 = 'ab', s2 = 'ab', 因为ab是两个串都有，ab排除，a也是两个串都有，排除，b也是两个串都有，排除。所以最长特殊序列不存在，返回-1
     * 通过以上分析，我们可以得出结论，如果：两个串相等（不仅长度相等，内容也相等），那么他们的最长特殊序列不存在。返回-1
     * 如果两个串长度不一样，那么长的串 永远也不可能是 短串的子序列，即len(s1) > len(s2),则最长特殊序列为s1,返回长度大的数 `
     */
    public int findLUSlength(String a, String b) {
        // a.equals(b)进行逻辑比较,当内容相同时,返回true
        // a == b是比较两个对象的引用,只有当a和b指 向的是堆中的同一个对象才会返回true
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }

    @Test
    public void findLUSlengthTest() {
        String a = "aaa";
        String b = "aaa";
        System.out.println(findLUSlength(a, b));
    }
}
