import org.junit.Test;

import java.util.*;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 03-31-2021 23:23
 */
public class SubsetsWithDup090 {

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    /**
     * 在递归时，若发现没有选择上一个数，且当前数字与上一个数相同，则可以跳过当前生成的子集
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return ans;
    }

    public void dfs(boolean choosePre, int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        dfs(false, cur + 1, nums);
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        t.add(nums[cur]);
        dfs(true, cur + 1, nums);
        t.remove(t.size() - 1);
    }


    /**
     * 一个有n个元素的集合而言,其共有2^n个子集
     * 将集合的各个元素依次编号为0到n-1的序列,各个位子上取0或1, 0到2^n-1刚好用于表示这些集合是否在对应的子集中,得到的恰好为所有子集
     */
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        // 2^n
        int sub = (1 << nums.length);
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < sub; i++) {
            int tmp = i;
            List<Integer> subset = new ArrayList<>();
            for (int t : nums) {
                if (tmp % 2 == 1) {
                    subset.add(t);
                }
                tmp /= 2;
            }
            Collections.sort(subset);
            ans.add(subset);
        }
        List<List<Integer>> res = new LinkedList<>();
        for (List i : ans) {
            res.add(i);
        }
        return res;
    }

    @Test
    public void subsetsWithDupTest() {
        int[] nums = {1, 2, 3};
        System.out.println(subsetsWithDup2(nums));
    }
}
