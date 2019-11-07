package main;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
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
    public static void main(String[] args) {
        int[] nums = {2,2,34,33};
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
//        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(5);
        MainTest m = new MainTest();
        System.out.println(m.divide(10,3));
    }
    public int divide(int dividend, int divisor) {
        boolean flag = true;
        //处理返回结果为正负
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = false;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        try {
            int result = dividend;
            int count = 0;
            while (result > divisor) {
                count++;
                result = result - divisor;
            }

            if (flag) {
                return count;
            } else {
                return Integer.valueOf("-" + count);
            }
        } catch (Exception e) {
            return Integer.MIN_VALUE;
        }


    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
