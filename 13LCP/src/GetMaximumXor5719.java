import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个 有序 数组 nums ，它由 n 个非负整数组成，同时给你一个整数 maximumBit 。你需要执行以下查询 n 次：
 * <p>
 * 找到一个非负整数 k < 2maximumBit ，使得 nums[0] XOR nums[1] XOR ... XOR nums[nums.length-1] XOR k 的结果 最大化 。k 是第 i 个查询的答案。
 * 从当前数组 nums 删除 最后 一个元素。
 * 请你返回一个数组 answer ，其中 answer[i]是第 i 个查询的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,1,3], maximumBit = 2
 * 输出：[0,3,2,3]
 * 解释：查询的答案如下：
 * 第一个查询：nums = [0,1,1,3]，k = 0，因为 0 XOR 1 XOR 1 XOR 3 XOR 0 = 3 。
 * 第二个查询：nums = [0,1,1]，k = 3，因为 0 XOR 1 XOR 1 XOR 3 = 3 。
 * 第三个查询：nums = [0,1]，k = 2，因为 0 XOR 1 XOR 2 = 3 。
 * 第四个查询：nums = [0]，k = 3，因为 0 XOR 3 = 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,4,7], maximumBit = 3
 * 输出：[5,2,6,5]
 * 解释：查询的答案如下：
 * 第一个查询：nums = [2,3,4,7]，k = 5，因为 2 XOR 3 XOR 4 XOR 7 XOR 5 = 7。
 * 第二个查询：nums = [2,3,4]，k = 2，因为 2 XOR 3 XOR 4 XOR 2 = 7 。
 * 第三个查询：nums = [2,3]，k = 6，因为 2 XOR 3 XOR 6 = 7 。
 * 第四个查询：nums = [2]，k = 5，因为 2 XOR 5 = 7 。
 * 示例 3：
 * <p>
 * 输入：nums = [0,1,2,2,5,7], maximumBit = 3
 * 输出：[4,3,6,4,6,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums.length == n
 * 1 <= n <= 105
 * 1 <= maximumBit <= 20
 * 0 <= nums[i] < 2maximumBit
 * nums 中的数字已经按 升序 排好序。
 *
 * @Author: zzStar
 * @Date: 04-18-2021 00:46
 */
public class GetMaximumXor5719 {

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int m = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            m = m ^ nums[i];
            for (int j = 1; j < (1 << maximumBit); j <<= 1) {
                if ((j & m) == 0) {
                    res[n - 1 - i] += j;
                }
            }
        }
        return res;
    }

    @Test
    public void getMaximumXorTest() {
        int[] nums = {0, 1, 2, 2, 5, 7};
        int mb = 3;
        System.out.println(Arrays.toString(getMaximumXor(nums, mb)));
    }
}
