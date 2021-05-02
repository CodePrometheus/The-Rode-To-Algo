import org.junit.Test;

/**
 * @Author: zzStar
 * @Date: 05-02-2021 10:30
 */
public class GetMinDistance5746 {


    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int res = n + 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                int tmp = Math.abs(i - start);
                res = Math.min(res, tmp);
            }
        }
        return res;
    }

    @Test
    public void getMinDistanceTest() {
        int[] num = {1, 2, 3, 4, 5};
        int t = 5;
        int s = 3;
        System.out.println(getMinDistance(num, t, s));
    }

}
