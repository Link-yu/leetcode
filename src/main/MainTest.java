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
        System.out.println(solution.isMatch("aa","a");
    }

    public boolean isMatch(String s, String p) {
        int start1 = 0;
        int start2 = 0;

        while(start1 <= s.length()-1 && start2 <= p.length()-1) {
            if (start2+1 <= p.length()-1 && p.charAt(start2+1) == '*' && (p.charAt(start2) == '.' || (s.charAt(start1) == p.charAt(start2)))) {
                start1++;
                continue;
            } else {
                start2++;
            }
        }
    }


}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
