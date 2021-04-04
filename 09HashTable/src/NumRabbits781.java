import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在answers数组里。
 * <p>
 * 返回森林中兔子的最少数量。
 * <p>
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 * <p>
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 * <p>
 * 输入: answers = []
 * 输出: 0
 * 说明:
 * <p>
 * answers的长度最大为1000。
 * answers[i]是在[0, 999]范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rabbits-in-forest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 04-04-2021 23:43
 */
public class NumRabbits781 {

    /**
     *
     */
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int num = 0;
        for (int answer : answers) {
            if (map.containsKey(answer) && map.get(answer) > 0) {
                map.put(answer, map.get(answer) - 1);
            } else {
                num += answer + 1;
                map.put(answer, answer);
            }
        }
        return num;
    }

    public int numRabbits2(int[] answers) {
        // m[i]>0   先前已经记录到有回答i的兔子,这次遇到只需容量减1
        // m[i]==0  第一次遇到回答i的兔子或者上一次遇到回答i的兔子时创建颜色的容量已经用完.
        // 创建新的颜色,容量为i,并将这一波兔子数量加到结果中
        int[] m = new int[1000];
        int result = 0;
        for (int i : answers) {
            if (m[i] > 0) {
                m[i]--;
            } else {
                m[i] = i;
                result += i + 1;
            }
        }
        return result;
    }

    @Test
    public void numRabbitsTest() {
        int[] nums = {1, 2, 3};
        System.out.println(numRabbits(nums));
        System.out.println(numRabbits2(nums));
    }
}
