import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: zzStar
 * @Date: 2022/3/9 4:21 PM
 */
public class InAndOut {

    // 1 5
    // 10 20
    // -----
    // 6
    // 30
    void one() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
    }

    // 2
    // 1 5
    // 10 20
    // -----
    // 6
    // 30
    void two() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }

    // 1 5
    // 10 20
    // 0 0
    // -----
    // 6
    // 30
    void three() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (a == 0 && b == 0) break;
            System.out.println(a + b);
        }
    }

    // 4 1 2 3 4
    // 5 1 2 3 4 5
    // 0
    // -----
    // 10
    // 15
    void four() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int sum = 0;
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }
    }

    // 2
    // 4 1 2 3 4
    // 5 1 2 3 4 5
    // -----
    // 10
    // 15
    void five() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int num = sc.nextInt();
            int sum = 0;
            for (int i = 0; i < num; i++) {
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }
    }

    // 4 1 2 3 4
    // 5 1 2 3 4 5
    // -----
    // 10
    // 15
    void six() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int res = 0;
            for (int j = 0; j < m; j++) {
                res += sc.nextInt();
            }
            System.out.println(res);
        }
    }

    // 1 2 3
    // 4 5
    // 0 0 0 0 0
    // -----
    // 6
    // 9
    // 0
    void seven() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            int sum = 0;
            String s = sc.nextLine();
            String[] nums = s.split(" ");
            for (int i = 0; i < nums.length; i++) {
                sum += Integer.valueOf(nums[i]);
            }
            System.out.println(sum);
        }
    }

    // 5
    // c d a bb e
    // -----
    // a bb c d e
    void eight() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] ans = sc.nextLine().split(" ");
        Arrays.sort(ans);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    // a c bb
    // f dddd
    // nowcoder
    // -----
    // a bb c
    // dddd f
    // nowcoder
    void nine() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String n = sc.nextLine();
            String[] str = n.split(" ");
            Arrays.sort(str);
            System.out.println(String.join(" ", str));
        }
    }

    // a,c,bb
    // f,dddd
    // nowcoder
    // -----
    // a,bb,c
    // dddd,f
    // nowcoder
    void ten() {
        Scanner scn = new Scanner(System.in);
        while (scn.hasNext()) {
            String[] arr = scn.nextLine().split(",");
            Arrays.sort(arr);
            for (int i = 0; i < arr.length - 1; i++) {
                System.out.print(arr[i] + ",");
            }
            System.out.println(arr[arr.length - 1]);
        }
    }

}
