package main;

import java.util.*;

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
        System.out.println(solution.longestPalindrome(""));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        if(s.length()<0 || s.equals(""))
            return "";


        int start = 0;
        int end = 0;
        String result = "";
        for (int i = 0; i < s.length();i++) {
            int len1 = aroundCenter(s, i,i);
            int len2 = aroundCenter(s, i, i+1);

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }

        return s.substring(start, end+1);
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
