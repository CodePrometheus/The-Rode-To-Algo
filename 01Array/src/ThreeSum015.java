import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 *
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 03-12-2021 08:45
 */
public class ThreeSum015 {

    /**
     * 首先，如果用暴力解，用一个三重循环遍历那么时间复杂度在O($N^3$)，然后稍微进行优化，根据题目：找到三元组不能重复
     * 可以想到，如果要排序（能保证重复出现的数字在一起，并且时间复杂度为O(NlogN)，没啥影响）
     * 可以在第二重循环的枚举中找到不小于当前第一重循环的枚举元素
     * 和第三重循环同理，找到不小于第二重循环的枚举元素
     * => 那么能想到了排序，但是本质上还是三重循环，那么时间复杂度还是O($N^3$)，继续优化，将下面的两重循环变成一重循环：
     * 可以发现我们是固定了第一个数然后去找其他两个数的，那么可以将后面两个数看成一个数，
     * 那么问题就变成了**在有序数组中从[i+1, len-1]这个范围内找到一个符合要求的数，
     * 那么就变成了双指针问题**，而这个数的值不再是mid，而是两个边界left和right的和。
     * 而指针的移动条件就是：如果当前的sum值太大，那么右指针就移动；如果sum太小，那么左指针就移动；
     * 如果值正好，那么就是当前值，并且左指针右移，右指针左移（因为是找到所有满足的解）；
     * 循环的结束条件就是左右指针相遇 而双指针情况下，第二三重循环就从O($N^2$)变成O(N)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            // 因为已经排序好，所以后面不可能有三个数加和等于0，直接返回结果
            if (nums[i] > 0) {
                return lists;
            }
            // 对于重复元素：跳过，避免出现重复解
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int cur = nums[i];
            // 双指针
            int l = i + 1, r = len - 1;
            while (l < r) {
                int tmp = cur + nums[l] + nums[r];
                // 判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R 移到下一位置，寻找新的解
                if (tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    lists.add(list);
                    while (l < r && nums[l + 1] == nums[l]) {
                        ++l;
                    }
                    while (l < r && nums[r - 1] == nums[r]) {
                        --r;
                    }
                    ++l;
                    --r;
                } else if (tmp < 0) {
                    ++l;
                } else {
                    --r;
                }
            }
        }
        return lists;
    }

    @Test
    public void threeSumTest() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
