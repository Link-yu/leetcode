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
        int[] words = {1,3,5,6};
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
//        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(5);
        MainTest m = new MainTest();
        System.out.println(m.searchInsert(words,8));
    }
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }

        if (target > nums[nums.length-1]) {
            return nums.length;
        }

        if (target < nums[0]) {
            return 0;
        }
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left <= right) {
            mid = (left + right)/2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (nums[mid] < target) {
            return mid+1;
        } else {
            return mid;
        }


    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
