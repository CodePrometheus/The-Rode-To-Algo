import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: zzStar
 * @Date: 04-05-2021 15:23
 */
public class PurchasePlans028 {

    /**
     * 排序 + 双指针
     */
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1_000_000_007;
        int l = 0, r = nums.length - 1;
        int count = 0;
        while (l < r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                // 直接else即可，此时左右也就是区间的最小值和最大值加在一起 <= target
                // 说明中间的数都满足要求
                count = count + (r - l);
                l++;
            }
            count = count % mod;
        }
        return count % mod;
    }

    @Test
    public void purchasePlansTest() {
        int[] nums = {2, 5, 3, 5};
        int target = 6;
        System.out.println(purchasePlans(nums, target));
    }
}
