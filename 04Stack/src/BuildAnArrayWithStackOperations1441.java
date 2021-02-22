import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个目标数组 target 和一个整数 n。每次迭代，需要从 list = {1,2,3..., n} 中依序读取一个数字。
 * <p>
 * 请使用下述操作来构建目标数组 target ：
 * <p>
 * Push：从 list 中读取一个新元素， 并将其推入数组中。
 * Pop：删除数组中的最后一个元素。
 * 如果目标数组构建完成，就停止读取更多元素。
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 * <p>
 * 请返回构建目标数组所用的操作序列。
 * <p>
 * 题目数据保证答案是唯一的
 * <p>
 *
 * @Author: zzStar
 * @Date: 02-22-2021 12:21
 */
public class BuildAnArrayWithStackOperations1441 {

    public List<String> buildArray(int[] target, int n) {
        /**
         * i从1遍历到n,同时从头开始对比target元素
         * 当元素i在target里面时只记录push操作,然后target移到下一元素
         * 否则(不在target中)丢弃该元素,即push再pop
         */
        List<String> res = new ArrayList<>();
        int i = 0;
        for (int j = 1; j <= n; j++) {
            if (i == target.length) {
                break;
            }
            if (target[i] == j) {
                res.add("Push");
                i++;
            } else {
                res.add("Push");
                res.add("Pop");
            }
        }
        return res;
    }

    @Test
    public void buildArrayTest() {
        int n = 4;
        int[] target = {1, 2};
        System.out.println(buildArray(target, n));
    }
}
