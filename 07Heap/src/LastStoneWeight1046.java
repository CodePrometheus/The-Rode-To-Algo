import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果x == y，那么两块石头都会被完全粉碎；
 * 如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 *
 * <p>
 * 示例：
 * <p>
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 03-14-2021 10:08
 */
public class LastStoneWeight1046 {

    /**
     * 递归
     */
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 2) {
            return Math.abs(stones[0] - stones[1]);
        }
        if (stones.length == 1) {
            return stones[0];
        }

        Arrays.sort(stones);

        /**
         * 长度 >= 3
         * 第一个数是0的话 直接其他两个数相减
         */
        if (stones[stones.length - 3] == 0) {
            return stones[stones.length - 1] - stones[stones.length - 2];
        }
        // 由于已经排好序了，所以开始大数相减 减完后第二大的数必然为0
        stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
        stones[stones.length - 2] = 0;
        return lastStoneWeight(stones);
    }


    /**
     *
     */
    public int lastStoneWeight2(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }


    /**
     * 手写大顶堆
     */
    public int lastStoneWeight3(int[] stones) {
        genHeap(stones);

        for (int i = 0; i < stones.length - 1; i++) {
            // for(int j = 0; j < stones.length; j++)
            //     System.out.print(stones[j]+" ");
            // System.out.println();
            int first = stones[0];
            stones[0] = 0;
            change(stones, 0);
            stones[0] = first - stones[0];
            change(stones, 0);
        }

        return stones[0];
    }

    // 生成堆
    private void genHeap(int[] nums) {
        for (int i = (nums.length - 2) / 2; i >= 0; i--) {
            change(nums, i);
        }
    }

    // 调整
    private void change(int[] nums, int start) {
        int next = 2 * start + 1;
        int tmp = nums[start];
        while (next < nums.length) {
            if (next < nums.length - 1 && nums[next + 1] > nums[next]) {
                next++;
            }
            if (nums[next] > tmp) {
                nums[start] = nums[next];
                start = next;
                next = 2 * start + 1;
            } else {
                break;
            }
        }
        nums[start] = tmp;
    }


    @Test
    public void lastStoneWeightTest() {
        int[] st = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(st));
        System.out.println(lastStoneWeight2(st));
        System.out.println(lastStoneWeight3(st));
    }

}
