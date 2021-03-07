import org.junit.Test;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 * <p>
 * 提示：
 * <p>
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * @Author: zzStar
 * @Date: 03-07-2021 11:49
 */
public class ReverseWords557 {

    /**
     * 双指针
     * 定义两个指针start和end，然后遍历字符串，直到找到空格为止。
     * 此时end - 1就是单词的结尾，再使用StringBuilder逆向拼接字符串，
     * 如果没有遍历完整个字符串就再拼接一个空格，
     * 然后end++指向下一个单词的开头，再把end赋值给start，
     * 直到遍历完整个字符串
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int start = 0, end = 0;
        while (end < chars.length) {
            while (end < chars.length && chars[end] != ' ') {
                end++;
            }
            for (int i = end - 1; i >= start; i--) {
                sb.append(chars[i]);
            }
            if (end < chars.length) {
                // 此时end位置的字符是空格
                sb.append(chars[end++]);
                // 前进
                start = end;
            }
        }
        return sb.toString();
    }

    /**
     * 开辟一个新字符串。然后从头到尾遍历原字符串，直到找到空格为止，此时找到了一个单词，并能得到单词的起止位置。随后，根据单词的起止位置，可以将该单词逆序放到新字符串当中。如此循环多次，直到遍历完原字符串，就能得到翻转后的结果。
     */
    public String reverseWords2(String s) {
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }

    @Test
    public void reverseWordsTest() {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
        System.out.println(reverseWords2(s));
    }
}
