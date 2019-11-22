package main;


import com.sun.xml.internal.ws.util.StringUtils;

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
        int[] words = {4,5,6,7,0,2,3};
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
//        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(5);
        MainTest m = new MainTest();
        System.out.println(m.search(words,4));
    }
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while(left<=right) {
            //左边有序
            int mid = (left + right)/2;
            if (nums[mid]== target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                //左边有序
                if(nums[left] > target || nums[mid] < target) {
                    left = mid+1;
                } else {
                    right = mid;
                }
            } else if (nums[mid] <= nums[right]) {
                //右边有序
                if (target > nums[right] || target < nums[mid] ) {
                    right = mid-1;
                } else {
                    left= mid;
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
