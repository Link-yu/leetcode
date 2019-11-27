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
    List<List<Integer>> listList = new ArrayList<>();
    public static void main(String[] args) {
        int[] words = {0,1,0,2,1,0,1,3,2,1,2,1};
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
//        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(5);
        MainTest m = new MainTest();
        System.out.println(m.trap(words));
    }

    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;
        for (int i = 1; i < height.length-1;i++) {
            int k = i-1;
            int t = i+1;
            while (k >=0) {
                if (height[k] > leftMax) {
                    leftMax = height[k];
                }
                k--;
            }

            while (t < height.length) {
                if (height[t] > rightMax) {
                    rightMax = height[t];
                }
                t++;
            }

            if (leftMax > height[i] && rightMax > height[i]) {
                result = result + Math.min(leftMax,rightMax)-height[i];
            }
            leftMax = 0;
            rightMax = 0;
        }
        return result;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
