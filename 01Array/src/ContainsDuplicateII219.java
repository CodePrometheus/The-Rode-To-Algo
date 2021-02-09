import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
 * <p>
 *
 * <p>
 *
 * @Author: zzStar
 * @Date: 02-09-2021 23:40
 */
public class ContainsDuplicateII219 {

    /**
     * 用散列表来维护这个k大小的滑动窗口
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // 在散列表中搜索当前元素，如果找到了就返回 true
            if (set.contains(nums[i])) {
                return true;
            }
            // 在散列表中插入当前元素
            set.add(nums[i]);
            // 如果当前散列表的大小超过了 kk， 删除散列表中最旧的元素
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    @Test
    public void containsNearbyDuplicateTest() {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, 3));
    }
}
