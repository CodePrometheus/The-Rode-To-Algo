import org.junit.Test;

/**
 * 给定一个二进制数组， 计算其中最大连续1的个数
 *
 * @Author: zzStar
 * @Date: 02-12-2021 21:58
 */
public class MaxConsecutiveOnes485 {

    /**
     * 双指针，相当于滑动窗口，记录连续1出现的头和尾，记录当前连续的长度和当前记录最大的连续长度两者取一个最大的
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 双指针
        int fast = 0;
        int slow = 0;
        int num = 0;
        while (fast < nums.length) {
            // 若是0
            if (nums[fast] == 0) {
                num = Math.max((fast - slow), num);
                slow = fast + 1;
                fast++;
            } else {
                fast++;
            }
        }
        // 遍历完，计算当前的最大1的长度
        num = Math.max((fast - slow), num);
        return num;
    }

    /**
     * 滑动窗口
     */
    public int findMaxConsecutiveOnes2(int[] nums) {
        int res = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                l = r + 1;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    @Test
    public void findMaxConsecutiveOnes() {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
        System.out.println(findMaxConsecutiveOnes2(nums));
    }
}
