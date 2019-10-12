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
        boolean[][] b = new boolean[2][2];
        System.out.println(solution.longestPalindrome("aabbaac"));
    }

    public String longestPalindrome(String s) {
        if (s.equals("") || s == null) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        int len = s.length();
        int start = 0;
        int end = 0;
        //二维数组f[i][j]表示s.substring(i,j+1) 为 回文子串
        boolean[][] f = new boolean[len][len];
        //需要特殊处理长度为1或长度为2的子字符串;单个字符都处理成true,两个的字符则要判断前后是否一致。
        for (int i = 0; i < len;i++) {
            f[i][i] = true;
            if (i < len-1 && s.charAt(i) == s.charAt(i+1)) {
                f[i][i+1] = true;
                start = i;
                end = i+1;
            }
        }

        //开始处理长度大于等于3的子串
        for (int i = 3; i<=len;i++) {
            for (int left = 0; left < len; left++) {
                int right = left+i-1;
                if (right > len-1) {
                    break;
                }
                if ( s.charAt(left) == s.charAt(right) && f[left+1][right-1]) {
                    f[left][right] = true;
                    if (right - left > end - start) {
                        start = left;
                        end = right;
                    }
                }
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
