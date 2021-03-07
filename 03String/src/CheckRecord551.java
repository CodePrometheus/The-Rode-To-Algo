import org.junit.Test;

/**
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 * <p>
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * <p>
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "PPALLP"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "PPALLL"
 * 输出: False
 * <p>
 *
 * @Author: zzStar
 * @Date: 03-07-2021 11:29
 */
public class CheckRecord551 {

    /**
     * indexOf
     */
    public boolean checkRecord(String s) {
        int i = 0;
        return !s.contains("LLL") && ((i = s.indexOf("A")) == -1 || i == s.lastIndexOf("A"));
    }

    /**
     * 正则
     * . : 匹配任何除了换行以外的单个字符。
     * <p>
     * * : 匹配 0 个或者 大于 0 个 * 符号前面的表达式。
     * <p>
     * .* : 匹配任何字符串
     * <p>
     * a|b : 要么匹配 a 要么匹配 b
     */
    public boolean checkRecord2(String s) {
        return !s.matches(".(A.*A|LLL).*");
    }

    public boolean checkRecord3(String s) {
        int count = 0;
        for (int i = 0; i < s.length() && count < 2; i++) {
            if (s.charAt(i) == 'A') {
                count++;
            }
            if (i < s.length() - 3 && s.charAt(i) == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
                return false;
            }
        }
        return count < 2;
    }

    @Test
    public void checkRecordTest() {
        String s = "LLLL";
        System.out.println(checkRecord(s));
        System.out.println(checkRecord2(s));
        System.out.println(checkRecord3(s));
    }
}
