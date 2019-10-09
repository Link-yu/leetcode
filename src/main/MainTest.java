package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        int[] nums = {2, 7, 11, 15};
        System.out.println(solution.twoSum2(nums,9));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode head = new ListNode(0);
        ListNode result = head;

        int carry = 0;
        while (t1 != null || t2 != null) {
            int temp = carry;
            carry = 0;
            if (t1 != null) {
                temp = temp + t1.val;
                t1 = t1.next;
            }

            if (t2 != null) {
                temp = temp + t2.val;
                t2 = t2.next;
            }

            if (temp/10 != 0) {
                carry = 1;
                temp = temp/10;
            }

            result.next = new ListNode(temp);
            result = result.next;
        }

        if (carry > 0) {
            result.next = new ListNode(carry);
        }
        return head.next;

    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
