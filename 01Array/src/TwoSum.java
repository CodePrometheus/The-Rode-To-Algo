import java.util.HashMap;

/**
 * 梦的起点
 *
 * @Author: zzStar
 * @Date: 02-01-2021 22:10
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];

        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                indexs[0] = hash.get(nums[i]);
                indexs[i] = i;
                return indexs;
            }
            hash.put(target - nums[i], i);
        }
        return indexs;
    }

}
