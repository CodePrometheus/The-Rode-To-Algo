import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 * <p>
 * 例如，在字符串 s = "abbxxxxzyy"中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * <p>
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 * <p>
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 * <p>
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2：
 * <p>
 * 输入：s = "abc"
 * 输出：[]
 * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3：
 * <p>
 * 输入：s = "abcdddeeeeaabbbcd"
 * 输出：[[3,5],[6,9],[12,14]]
 * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
 * 示例 4：
 * <p>
 * 输入：s = "aba"
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅含小写英文字母
 *
 * @Author: zzStar
 * @Date: 02-26-2021 14:05
 */
public class PositionsOfLargeGroups830 {

    /**
     * 遍历该序列，并记录当前分组的长度。如果下一个字符与当前字符不同，或者已经枚举到字符串尾部，
     * 就说明当前字符为当前分组的尾部。每次找到当前分组的尾部时，如果该分组长度达到 3，我们就将其加入答案
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ret = new ArrayList<>();
        int n = s.length();
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return ret;
    }

    /**
     * 只需要找到连续的大于等于3的字符的起始和结束的下标，这个下标只能是越来越大，
     * 其实就相当于已经排序了，只需要把它存放到集合res中即可。
     */
    public List<List<Integer>> largeGroupPositions2(String s) {
        List<List<Integer>> res = new ArrayList<>();
        // 相同字符串左边边界
        int left = 0;
        int length = s.length();
        while (left < length) {
            // 相同字符串的长度
            int count = 0;
            // 统计相同字符串的长度
            while (left + count < length && s.charAt(left) == s.charAt(left + count)) {
                count++;
            }
            // 如果长度大于等于3，就把他加入到res中
            if (count >= 3) {
                res.add(Arrays.asList(left, left + count - 1));
            }
            // 更新下一个字符串的左边边界
            left = left + count;
        }
        return res;
    }


    @Test
    public void largeGroupPositionsTest() {
        String s = "abbxxxxzzy";
        System.out.println(largeGroupPositions(s));
        System.out.println(largeGroupPositions2(s));
    }
}
