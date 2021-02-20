import org.junit.Test;

/**
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 * <p>
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写，比如"Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 * <p>
 *
 * @Author: zzStar
 * @Date: 02-20-2021 22:44
 */
public class DetectCapital520 {

    /**
     * 1.大写字母个数为0，或者大写字母个数为字符串长度，说明此时为全大写或者全小写，返回true。
     * 2.首字母大写，大写字母个数为1，说明此时只有首字母大写，返回true。
     */
    public boolean detectCapitalUse(String w) {
        int cnt = 0, i = w.length();
        // 统计大写的个数
        while (i-- > 1) {
            if (w.charAt(i) <= 'Z') {
                cnt++;
            }
        }
        return cnt == 0 || cnt == w.length() - 1 && w.charAt(0) <= 'Z';
    }

    @Test
    public void detectCapitalUseTest() {
        String w = "leetcOde";
        System.out.println(detectCapitalUse(w));
    }
}
