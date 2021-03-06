import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤输入数组的大小。
 *
 * @Author: zzStar
 * @Date: 03-06-2021 13:13
 */
public class MaxSlidingWindow059 {

    /**
     * 用双向队列存储数组的**下标**，每一轮进行**移动窗口、维护和输出**的动作
     * 每一轮使**最大的数对应的下标**在双向队列的**最左端**，如果双向队列中“左边下标对应的元素”要小于“右边下标对应的元素”，那么就把左边的元素进行清除维护
     * 输出双向队列最左端下标对应的元素
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - (k - 1)) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                ans[i - (k - 1)] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }

    /**
     * 单调队列模板题，求滑动窗口的最值
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && i - queue.peek() >= k) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                res[j++] = nums[queue.peek()];
            }
        }
        return res;
    }

    /**
     * 使用下标记住每个窗口的最大值位置，
     * 窗口每次向右移动一步，直到窗口右端超出数组长度
     * 当最大值位置不在当前窗口就让最大值下标放到当前窗口第一个位置，再在当前窗口定位最大值
     * 如果最大值位置再当前窗口内部，则直接比较当前窗口最右边数与最大值即可，
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums.length <= 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int maxIdx = -1;
        int left = 0, right = k - 1;
        while (right < nums.length) {
            // 如果最大值不在当前窗口内，重新定位最大值
            if (maxIdx < left) {
                maxIdx = left;
                for (int i = left; i <= right; i++) {
                    maxIdx = (nums[maxIdx] < nums[i]) ? i : maxIdx;
                }
            } else {
                // 如果最大值在当前窗口内部，直接比较最大值与窗口最右边数值
                maxIdx = (nums[maxIdx] < nums[right]) ? right : maxIdx;
            }
            // 存储最大值
            res[left] = nums[maxIdx];
            // 窗口左右边界同时右移一步
            left++;
            right++;
        }
        return res;
    }

    @Test
    public void maxSlidingWindowTest() {
        int[] num = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(num, k)));
        System.out.println(Arrays.toString(maxSlidingWindow2(num, k)));
        System.out.println(Arrays.toString(maxSlidingWindow3(num, k)));
    }
}
