import java.util.HashSet;
import java.util.Set;

/**
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 * <p>
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断sentence 是否为 全字母句 。
 * <p>
 * 如果是，返回 true ；否则，返回 false 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 * 示例 2：
 * <p>
 * 输入：sentence = "leetcode"
 * 输出：false
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= sentence.length <= 1000
 * sentence 由小写英语字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-the-sentence-is-pangram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 04-18-2021 10:31
 */
public class CheckIfPangram5734 {

    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (Character res : sentence.toCharArray()) {
            set.add(res);
        }
        return set.size() == 26;
    }

    public boolean checkIfPangram2(String sentence) {
        int[] res = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            res[sentence.charAt(i) - 'a']++;
        }
        // 都包含意味着26个位置必须有数
        for (int i = 0; i < 26; i++) {
            if (res[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
