package com.star.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * <p>
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
 * 示例 3：
 * <p>
 * 输入：nums = [-1,3,2,0]
 * 输出：true
 * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 104
 * -109 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/132-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 03-24-2021 22:38
 */
public class Find132Pattern {

    /**
     * 在单调栈中，从栈底到栈顶的元素是严格单调递减的。当给定阈值 xx 时，我们只需要不断地弹出栈顶的元素，直到栈为空或者 xx 严格小于栈顶元素。此时我们再将 xx 入栈，这样就维护了栈的单调性。
     * <p>
     * 因此，我们可以使用单调栈作为维护 22 的数据结构，并给出下面的算法：
     * <p>
     * 我们用单调栈维护所有可以作为 22 的候选元素。初始时，单调栈中只有唯一的元素 \textit{a}[n-1]a[n−1]。我们还需要使用一个变量 \textit{max\_k}max_k 记录所有可以真正作为 22 的元素的最大值；
     * <p>
     * 随后我们从 n-2n−2 开始从右到左枚举元素 a[i]a[i]：
     * <p>
     * 首先我们判断 a[i]a[i] 是否可以作为 11。如果 a[i] < \textit{max\_k}a[i]<max_k，那么它就可以作为 11，我们就找到了一组满足 132132 模式的三元组；
     * <p>
     * 随后我们判断 a[i]a[i] 是否可以作为 33，以此找出哪些可以真正作为 22 的元素。我们将 a[i]a[i] 不断地与单调栈栈顶的元素进行比较，如果 a[i]a[i] 较大，那么栈顶元素可以真正作为 22，将其弹出并更新 \textit{max\_k}max_k；
     * <p>
     * 最后我们将 a[i]a[i] 作为 22 的候选元素放入单调栈中。这里可以进行一个优化，即如果 a[i] \leq \textit{max\_k}a[i]≤max_k，那么我们也没有必要将 a[i]a[i] 放入栈中，因为即使它在未来被弹出，也不会将 \textit{max\_k}max_k 更新为更大的值。
     * <p>
     * 在枚举完所有的元素后，如果仍未找到满足 132132 模式的三元组，那就说明其不存在。
     */
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> candidateK = new LinkedList<Integer>();
        candidateK.push(nums[n - 1]);
        int maxK = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] < maxK) {
                return true;
            }
            while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                maxK = candidateK.pop();
            }
            if (nums[i] > maxK) {
                candidateK.push(nums[i]);
            }
        }

        return false;
    }

}
