import java.util.Arrays;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 * <p>
 * 输入：nums = [10]
 * 输出："10"
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 04-12-2021 22:40
 */
public class LargestNumber179 {

    /**
     * 将数组内元素逐个转化为字符串后，直接通过compareTo方法比较
     * a.compareTo(b)：它是从头开始比较对应字符的大小(ASCII码顺序)
     * 如果a的第一个字符和b的第一个字符不等，结束比较，返回他们之间的长度差值
     * 如果a的第一个字符和b的第一个字符相等，则a的第二个字符和b的第二个字符做比较
     * 以此类推,直至比较的字符或被比较的字符有一方结束。
     */
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        // 通过比较(a+b)和(b+a)的大小，就可以判断出a,b两个字符串谁应该在前面
        // 所以[3,30,34]排序后变为[34,3,30]  [233，23333]排序后变为[23333，233]
        Arrays.sort(str, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        // 如果排序后的第一个元素是0，那后面的元素肯定小于或等于0，则可直接返回0
        if (str[0].equals("0")) {
            return "0";
        }
        //
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(str[i]);
        }
        return builder.toString();
    }

}
