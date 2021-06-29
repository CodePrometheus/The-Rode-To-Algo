/**
 * 请你设计一个管理 n个座位预约的系统，座位编号从1到n。
 * <p>
 * 请你实现SeatManager类：
 * <p>
 * SeatManager(int n)初始化一个SeatManager对象，它管理从 1到 n编号的n个座位。所有座位初始都是可预约的。
 * int reserve()返回可以预约座位的最小编号，此座位变为不可预约。
 * void unreserve(int seatNumber)将给定编号seatNumber对应的座位变成可以预约。
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"]
 * [[5], [], [], [2], [], [], [], [], [5]]
 * 输出：
 * [null, 1, 2, null, 2, 3, 4, 5, null]
 * <p>
 * 解释：
 * SeatManager seatManager = new SeatManager(5); // 初始化 SeatManager ，有 5 个座位。
 * seatManager.reserve();    // 所有座位都可以预约，所以返回最小编号的座位，也就是 1 。
 * seatManager.reserve();    // 可以预约的座位为 [2,3,4,5] ，返回最小编号的座位，也就是 2 。
 * seatManager.unreserve(2); // 将座位 2 变为可以预约，现在可预约的座位为 [2,3,4,5] 。
 * seatManager.reserve();    // 可以预约的座位为 [2,3,4,5] ，返回最小编号的座位，也就是 2 。
 * seatManager.reserve();    // 可以预约的座位为 [3,4,5] ，返回最小编号的座位，也就是 3 。
 * seatManager.reserve();    // 可以预约的座位为 [4,5] ，返回最小编号的座位，也就是 4 。
 * seatManager.reserve();    // 唯一可以预约的是座位 5 ，所以返回 5 。
 * seatManager.unreserve(5); // 将座位 5 变为可以预约，现在可预约的座位为 [5] 。
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * 1 <= seatNumber <= n
 * 每一次对reserve的调用，题目保证至少存在一个可以预约的座位。
 * 每一次对unreserve的调用，题目保证seatNumber在调用函数前都是被预约状态。
 * 对reserve 和unreserve的调用总共不超过105次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/seat-reservation-manager
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 05-02-2021 09:32
 */
public class SeatManager5731 {

    int[] array;

    public SeatManager5731(int n) {
        array = new int[n];
    }

    public int reserve() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[1] = 1;
                return i + 1;
            }
        }
        return 0;
    }

    public void unreserve(int seatNumber) {
        array[seatNumber - 1] = 0;
    }


}
