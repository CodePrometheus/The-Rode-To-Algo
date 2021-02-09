import org.junit.Test;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @Author: zzStar
 * @Date: 02-09-2021 23:15
 */
public class MajorityElement169 {

    /**
     * 从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数
     */
    public int majorityElement(int[] nums) {
        int count = 1;
        int maj = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maj == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    maj = nums[i + 1];
                }
            }
        }
        return maj;
    }

    @Test
    public void majorityElementTest() {
        int[] nums = {2, 3, 4};
        System.out.println(majorityElement(nums));
    }
}
