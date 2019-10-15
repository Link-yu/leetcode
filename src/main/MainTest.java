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
        int[] nums1 = {1,8,6,2,5,4,8,3,7};
        int[] nums2 = {3,4};
        char[][] b = new char[2][3];
//        if (b[0][0] == '\0') {
//            System.out.println(b.length);
//
//        }
        String s = " afa afa aga ";
//        System.out.println(s.strip());
        System.out.println(solution.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int res = 0;
        int stage = 0;
        int[] record = new int[26];
        record['I' - 'A'] = 1;
        record['V' - 'A'] = 5;
        record['X' - 'A'] = 10;
        record['L' - 'A'] = 50;
        record['C' - 'A'] = 100;
        record['D' - 'A'] = 500;
        record['M' - 'A'] = 1000;


        for(int i = 0;i < s.length() - 1;i++){
            if(record[s.charAt(i) - 'A'] >= record[s.charAt(i + 1) - 'A']){
                res = res + record[s.charAt(i) - 'A'];
            }else{
                res = res - record[s.charAt(i) - 'A'];
            }
        }

        res = res + record[s.charAt(s.length() - 1) - 'A'];
        return res;
    }


}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
