package com.star.plus;

import java.util.Stack;

/**
 * 去除字符串中的"ac" "b"字符
 *
 * @Author: zzStar
 * @Date: 04-14-2022 19:31
 */
public class RemoveChar {
    public static void main(String[] args) {
        System.out.println(remove("bbdfg"));
        System.out.println(remove("ghghacbdsfds"));
        System.out.println(remove("dfaaabbbcccdfdf"));
    }

    static String remove(String str) {
        if (str == null || str.equals("")) return str;
        Stack<Character> s = new Stack<>();
        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c == 'b') {
                i++; // 越过
            } else if (c != 'c') {
                s.push(c);
                i++;
            } else if (c == 'c') {
                if (!s.isEmpty() && s.peek() == 'a') {
                    s.pop();
                    i++;
                } else {
                    s.push(c);
                    i++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.reverse().toString();
    }

}
