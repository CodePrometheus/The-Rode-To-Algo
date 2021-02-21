import org.junit.Test;

/**
 * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * @Author: zzStar
 * @Date: 02-21-2021 23:10
 */
public class RemoveAllAdjacentDuplicatesInString1047 {

    /**
     * 用栈来维护没有重复项的字母序列：
     * <p>
     * 若当前的字母和栈顶的字母相同，则弹出栈顶的字母；
     * <p>
     * 若当前的字母和栈顶的字母不同，则放入当前的字母
     */
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1)) {
                sb.deleteCharAt(sbLength-- - 1);
            } else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }

    @Test
    public void removeDuplicatesTest() {
        String s = "abbac";
        System.out.println(removeDuplicates(s));
    }
}
