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
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
//        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(5);
        MainTest m = new MainTest();
        System.out.println(m.reverseKGroup(l,2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        ListNode first = fakeHead.next;
        ListNode ptr = first;
        while(ptr != null && ptr.next != null) {
            int count = k;
            while (count>1) {
                if(ptr==null) break;
                ptr = ptr.next;
                count--;
            }
            if (ptr == null) {
                return pre.next;
            }
            ListNode next = ptr.next;

            fakeHead.next = rollBack(first, ptr);
            first.next = next;
            fakeHead = first;
            first = fakeHead.next;
            ptr = first;
        }
        return pre.next;
    }

    public ListNode rollBack(ListNode head, ListNode tail) {
        ListNode ptr=head;
        ListNode temp=ptr.next;
        while(ptr!=tail)//倒置节点，如果ptr到了最后一个节点，那就不必要了
        {
            ListNode tnext=temp.next;
            temp.next=ptr;
            ptr=temp;
            temp=tnext;
        }
        return ptr;
    }



}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
