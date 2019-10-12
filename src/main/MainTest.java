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
        char[][] b = new char[2][3];
//        if (b[0][0] == '\0') {
//            System.out.println(b.length);
//
//        }
        System.out.println(solution.convert("PAYPALISHIRING",3));
    }

    public String convert(String s, int numRows) {
        int len = s.length();
        String st = "";
        if(len == 0 || numRows<=1) {
            return s;
        }
        String[] ans = new String[numRows];
        int row = 0;
        int flag = 1;
        Arrays.fill(ans, "");
        for(int i = 0; i < s.length(); i++) {
            ans[row] += s.charAt(i);
            row += flag;

            if(row >=numRows) {
                row = numRows -2;
                flag = -1;
            }

            if(row < 0){
                row = 1;
                flag = 1;
            }
        }
        for(int i = 0; i<ans.length;i++) {
            st += ans[i];
        }
        return st;
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
