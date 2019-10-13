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
        System.out.println(solution.reverse(-123));
    }

    public int reverse(int x) {
        Queue<Integer> stack = new LinkedBlockingQueue<>();
        boolean flag = true;
        if (x < 0) {
            flag = false;
        }

        String s = String.valueOf(x);
        int len = flag?s.length():s.length()-1;
        for (int i =0 ;i < len;i++) {
            Integer t = x%10;
            x = x / 10;
            stack.add(t);
        }
        Long temp = 0L;
        while(!stack.isEmpty()) {
            temp = temp*10 + stack.poll();
        }
        int result = temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE? 0:temp.intValue();
        return flag? result:result;
    }

    public int aroundCenter(String s, int left, int right) {
        while (left >=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }



    public boolean isHuiwen(String s) {
        int start = 0;
        int end = s.length()-1;

        while (start <= end) {
            if (s.charAt(start++) == s.charAt(end--)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }


}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
