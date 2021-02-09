import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给定一个已按照 升序排列 的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * <p>
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 *
 * @Author: zzStar
 * @Date: 02-09-2021 23:01
 */
public class TwoSumII167 {

    /**
     * 双指针
     */
    public int[] twoSum(int[] numbers, int target) {
        // 一个在头，一个在尾
        for (int i = 0, j = numbers.length - 1; i < j; ) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

    /**
     * 二分查找 nlogn
     */
    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }


    @Test
    public void twoSumIITest() {
        int[] num = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(num, target)));
    }
}
