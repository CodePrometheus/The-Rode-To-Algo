import java.util.PriorityQueue;

/**
 * 寻找一个无序数组的中位数
 *
 * @Author: zzStar
 * @Date: 07-24-2022
 */
public class FindNoSortedArrayMedianNum {
    public static void main(String[] args) {
        System.out.println(find(new int[]{7, 2, 4, 9, 1, 5, 0}));
    }

    /**
     * 小顶堆，k=len/2+1，标是在最小堆里存数组中后k个数，则小顶堆顶就是中位数
     * 如果遇到比小顶堆堆顶大的数，就删除堆顶插入新的数，否则继续
     */
    static double find(int[] nums) {
        // 默认是小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int len = nums.length, k = len / 2 + 1;
        // 先向堆中插入前k个数
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        // 依次与后k个数作比较
        for (int i = k; i < len; i++) {
            if (queue.peek() < nums[i]) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        if (len % 2 == 0) {
            return (queue.poll() + queue.peek()) / 2.0;
        } else {
            return queue.peek();
        }
    }
}
