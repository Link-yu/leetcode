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
        System.out.println(m.strStr("","a"));
    }
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i =0 ;i < haystack.length();i++) {
            int start = 0;
            if (haystack.charAt(i) != needle.charAt(start)) {
                continue;
            } else {
                int first = i;
                while (start<needle.length() && first<haystack.length()) {
                    if (haystack.charAt(first) == needle.charAt(start)) {
                        first++;
                        start++;
                    } else {
                        break;
                    }
                }
                if (start == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
