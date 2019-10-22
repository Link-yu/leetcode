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
        int[] nums1 = {0,0,0,0};
        int[] nums2 = {1,3,4};
        char[][] b = new char[2][3];
        String[] strs = {"flower","flow","flight"};
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(7);
//        node.next.next.next.next = new ListNode(5);
        List<String> list = new ArrayList<>();
//        solution.quan(nums2,0, "", list);
        ListNode[] lists = {l1, l2};
        System.out.println(solution.mergeKLists(lists));
        System.out.println(strs[0].substring(0, strs[0].length()-1));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;

        return merge(lists,result,0);

    }

    public ListNode merge(ListNode[] lists, ListNode temp, int index) {
        if (index == lists.length) {
            return temp;
        }
        temp = mergeTwoLists(lists[index], temp);
        return merge(lists, temp, index+1);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tmp = result;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if (l1 != null) {
            tmp.next = l1;
        }

        if (l2 != null) {
            tmp.next = l2;
        }

        return result.next;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
