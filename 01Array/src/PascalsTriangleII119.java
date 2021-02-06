import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * @Author: zzStar
 * @Date: 02-06-2021 23:36
 */
public class PascalsTriangleII119 {

    /**
     * 获取杨辉三角的指定行
     * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
     * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex - i) / (i + 1);
        }
        return res;
    }

    /**
     * 题目要求使用 O(k) 的空间复杂度，所以我们只能创建一个集合。我们知道第 i 行的第 j 个数的值，是 i-1 行的中 j-1 和 j 值的和。由于我们只有一个集合，所以需要不断的覆盖，所以第 j 个数的值等于前一个值加上当前值的和。因为集合中的值是不断覆盖，所以我们获取到的前一个值并不是我们想要的（因为上次循环把覆盖了）。有两种解决办法：
     * <p>
     * 创建一个中间变量记录前一个值（不推荐）；
     * 逆序构造每一行（代码如下）。
     */
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                list.set(j, list.get(j - 1) + list.get(j));
            }
            list.add(1);
        }
        return list;
    }

    @Test
    public void pascalsTriangleIITest() {
        System.out.println(getRow(0));
        System.out.println(getRow2(0));
    }
}
