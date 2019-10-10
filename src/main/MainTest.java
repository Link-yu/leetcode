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
        System.out.println(solution.longestPalindrome());
    }

    public String longestPalindrome(String s) {
        int max = 0;
        for (int i = 0; i < s.length();i++) {
            for (int j = i+1; j < s.length();j++) {

            }
        }
    }


}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
