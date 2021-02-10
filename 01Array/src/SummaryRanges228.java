import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * <p>
 *
 * @Author: zzStar
 * @Date: 02-10-2021 23:10
 */
public class SummaryRanges228 {

    /**
     * 从数组的位置 00 出发，向右遍历。每次遇到相邻元素之间的差值大于 11 时，我们就找到了一个区间。遍历完数组之后，就能得到一系列的区间的列表。
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; ++i) {
            if (!(i + 1 < nums.length && nums[i] == nums[i + 1] - 1)) {
                if (sb.length() > 0) {
                    sb.append("->");
                }
                sb.append(nums[i]);
                ans.add(sb.toString());
                sb = new StringBuilder();
            } else {
                if (sb.length() == 0) {
                    sb.append(nums[i]);
                }
            }
        }
        return ans;
    }

    /**
     * 双指针
     * 使用 双指针，i 指向每个区间的起始位置，j 从 i 开始向后遍历直到不满足连续递增（或 j 达到数组边界），则当前区间结束；然后将 i 指向更新为 j + 1，作为下一个区间的开始位置，j 继续向后遍历找下一个区间的结束位置，如此循环，直到输入数组遍历完毕。
     */
    public List<String> summaryRanges2(int[] nums) {
        List<String> res = new ArrayList<>();
        // i 初始指向第 1 个区间的起始位置
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            // j 向后遍历，直到不满足连续递增(即 nums[j] + 1 != nums[j + 1])
            // 或者 j 达到数组边界，则当前连续递增区间 [i, j] 遍历完毕，将其写入结果列表。
            if (j + 1 == nums.length || nums[j] + 1 != nums[j + 1]) {
                // 将当前区间 [i, j] 写入结果列表
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                if (i != j) {
                    sb.append("->").append(nums[j]);
                }
                res.add(sb.toString());
                // 将 i 指向更新为 j + 1，作为下一个区间的起始位置
                i = j + 1;
            }
        }
        return res;
    }

    @Test
    public void summaryRangesTest() {
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums));
        System.out.println(summaryRanges2(nums));
    }
}
