import org.junit.Test;

import java.util.*;

/**
 * 给定一个范围在 1 ≤ a[i] ≤ n (n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * @Author: zzStar
 * @Date: 02-12-2021 21:04
 */
public class FindAllNumbersDisappearedInAnArray448 {

    /**
     * 原地修改
     * 找出 1 - n 中没有出现的数字。不能使用额外的空间，两次循环时间复杂度为 2O(n)，即为 O(n)。
     * <p>
     * 解题思路：使用数组的下标来标记数字的出现于否，通过一遍遍历即可标记出全部已经出现的数组
     * <p>
     * [4,3,2,7,8,2,3,1] 初始数据
     * <p>
     * [4,3,2,-7,8,2,3,1] 第一个数据 4 出现，将数组的第四个也就是下标 3 的数据修改为负数。-7 计算时，通过绝对值处理一下即可不影响数据的计算
     * [4,3,-2,-7,8,2,3,1]
     * [4,-3,-2,-7,8,2,3,1]
     * [4,-3,-2,-7,8,2,-3,1]
     * [4,-3,-2,-7,8,2,-3,-1]
     * [4,-3,-2,-7,8,2,-3,-1]
     * [4,-3,-2,-7,8,2,-3,-1]
     * [-4,-3,-2,-7,8,2,-3,-1]
     * <p>
     * 计算结束，数组的第五个，第六个依然为整数，证明 5,6 没有出现
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        // 将所有正数作为数组下标，置对应数组值为负值。
        // 那么，仍为正数的位置即为（未出现过）消失的数字
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                results.add(i + 1);
            }
        }
        return results;
    }

    @Test
    public void findDisappearedNumbersTest() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
