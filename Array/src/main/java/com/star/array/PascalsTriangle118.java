package com.star.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * @Author: zzStar
 * @Date: 02-06-2021 22:47
 */
public class PascalsTriangle118 {

    /**
     * 本行元素等于上一行元素往后错一位再逐个相加
     * 因此我们只要对最后一行单独处理：最后一行首、尾分别添加一个零然后对应位置求和就可以得到新的一行
     */
    public List<List<Integer>> generate(int numRows) {
        //创建一个Lists来存储list
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            //每次创建一个list来保存
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                //判断是不是第一个和最后一个
                if (j == 0 || j == i) {
                    //如果是直接添加1
                    list.add(1);
                } else {
                    //获取上一行的list,然后获取它的下表
                    //这里j是不会等于0的,因为上面已经判断了,因此如果这个成立
                    //比如是第三行i为2,j为1的时候
                    //i-1也就是2-1,就获取了第二行的,然后获取它的值j-1也就是1-1
                    //也就获取了第二行第一个,得到1,然后加同样的第二行的第二个
                    //i-1也就是2-1,并且j为1也就是第二行的第二个
                    //不需要当心越界的情况,因为如果是最后一个,同样不会执行这个语句
                    list.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
                }
            }
            //把list的内容添加到lists中
            lists.add(list);
        }
        return lists;
    }

    /**
     * 帕斯卡三角形
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     * 1 4 6 4 1
     * 1 5 10 10 5 1
     */
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        int[][] arr = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
                subList.add(arr[i][j]);
            }
            list.add(subList);
        }
        return list;
    }


    @Test
    public void generateTest() {
        System.out.println(generate(5));
        System.out.println(generate2(5));
    }


}
