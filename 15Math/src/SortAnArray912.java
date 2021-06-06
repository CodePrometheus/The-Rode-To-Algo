import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 给你一个整数数组nums，请你将该数组升序排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 06-06-2021 22:50
 */
public class SortAnArray912 {

    private static Random random = new Random();

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int idx = partition(nums, l, r);
            quickSort(nums, l, idx - 1);
            quickSort(nums, idx + 1, r);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int idx = random.nextInt(r - l) + l;
        swap(nums, l, idx);
        int mid = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= mid) {
                --r;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= mid) {
                ++l;
            }
            nums[r] = nums[l];
        }
        nums[l] = mid;
        return l;
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    @Test
    public void testQuickSort() {
        int[] nums = {5, 2, 3, 1};
        System.out.println(Arrays.toString(sortArray(nums)));
    }

}
