package main;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created on 2017/7/17.
 * Title: Simple
 * Description: Example
 * Copyright: Copyright(c) 2016
 * Company: 杭州公共交通云科技有限公司
 *
 * @author 维斯
 */
public class MainTest {
    int[] result = new int[2];
    public static void main(String[] args) {
        MainTest solution = new MainTest();
        int[] nums1 = {1,2,7};
        int[] nums2 = {3,4};
        char[][] b = new char[2][3];
//        if (b[0][0] == '\0') {
//            System.out.println(b.length);
//
//        }
        String s = " afa afa aga ";
//        System.out.println(s.strip());
        System.out.println(solution.myAtoi("42"));
    }

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] arr = str.toCharArray();
        long res = 0;
        int first = 0;
        //第一个非空白字符
        for (; first < arr.length; first++) {
            if(arr[first] ==' ')continue;
            //如果第一个非空是-或者+,，继续盘判断下一个
            if (arr[first] == '-' || arr[first] == '+') {
                //下一个如果是数字，结束循环；
                if (first + 1 < arr.length && (arr[first + 1] >= '0' && arr[first + 1] <= '9')) {
                    first++;
                    break;
                } else {
                    //下一个不是数字，返回0
                    return 0;
                }
            }
            if (arr[first] >= '0' && arr[first] <= '9') {
                break;
            } else return 0;
        }

        for (int i = first; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                res = res * 10 + arr[i] - '0';
                if (res > Integer.MAX_VALUE) {
                    break;
                }
            } else break;
        }
        if (first != 0 && arr[first - 1] == '-') {
            if (-res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            return (int) -res;
        }

        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) res;
    }



}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
