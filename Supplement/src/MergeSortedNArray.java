import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并 n 个有序数组
 *
 * @Author: zzStar
 * @Date: 04-14-2022 09:36
 */
public class MergeSortedNArray {

    @Test
    public void test() {
        int[] a1 = {2, 3, 5, 20}, a2 = {2, 4, 6, 8, 10, 12}, a3 = {1, 9, 11};
        List<int[]> list = new ArrayList<>(Arrays.asList(a1, a2, a3));
        int[] res = mergeAll(list, 0, list.size() - 1);
        System.out.println(Arrays.toString(res));
    }

    int[] merge(int[] arr1, int[] arr2) {
        int m = 0;
        int n = 0;
        int[] mergeArr = new int[arr1.length + arr2.length];
        int i = 0;
        while (m < arr1.length || n < arr2.length) {
            if (m >= arr1.length) {
                mergeArr[i++] = arr2[n++];
            } else if (n >= arr2.length) {
                mergeArr[i++] = arr1[m++];
            } else if (arr1[m] < arr2[n]) {
                mergeArr[i++] = arr1[m++];
            } else {
                mergeArr[i++] = arr2[n++];
            }
        }

        return mergeArr;
    }

    int[] mergeAll(List<int[]> list, int l, int r) {
        if (l >= r) {
            return list.get(l);
        }
        int mid = l + r >> 1;
        int[] left = mergeAll(list, l, mid);
        int[] right = mergeAll(list, mid + 1, r);
        return merge(left, right);
    }

}
