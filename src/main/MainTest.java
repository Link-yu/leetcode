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
    int[] result = new int[2];
    public static void main(String[] args) throws SocketException {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        MainTest m = new MainTest();
        System.out.println(m.reverseKGroup(l,2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode(0);
        result.next = head;

        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = result;
        while (temp != null) {
            for (int i = 0; i < k; i++) {
                if (temp == null) {
                    break;
                }
                temp = temp.next;
            }
        }
    }



}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
