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
        System.out.println(solution.myAtoi("-"));
    }

    public int myAtoi(String str) {
        if (str.length() <=0) {
            return 0;
        }
        StringBuffer s1 = new StringBuffer();
        for (int i = 0;i < str.length();i++) {
            if (str.charAt(i) != '\0') {
                s1.append(str.charAt(i));
            }
        }

        String temp = s1.toString();
        StringBuffer stringBuffer = new StringBuffer();
        int start =0;
        if (temp.charAt(0) == '-') {
            stringBuffer.append("-");
            start = 1;
        }
        for (int i = start; i < temp.length();i++) {
            if (temp.charAt(i) >= 48 && temp.charAt(i) <= 57) {
                stringBuffer.append(temp.charAt(i));
            } else {
                break;
            }
        }
        if (stringBuffer.length() == 0) {
            return 0;
        }
        Long result = Long.valueOf(stringBuffer.toString());
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) Integer.valueOf(stringBuffer.toString());
    }



}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
