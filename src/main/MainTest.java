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
        System.out.println(m.multiply("498828660196","840477629533"));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('0',0);
        map.put('1',1);
        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);

        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        String result = "";
        for(int i = nums2.length-1; i >= 0; i--) {
            int first = map.get(nums2[i]);
            StringBuilder red = new StringBuilder();
            for (int j = nums1.length-1;j>=0;j--) {
                int count1 = nums1.length -1 -j;
                StringBuilder t = new StringBuilder();
                while(count1 > 0) {
                    t = t.append("0");
                    count1--;
                }
                int second = map.get(nums1[j]);
                red = new StringBuilder(addStrings(red.toString(), new StringBuilder(first*second).append(t).toString()));
            }
            int count = nums2.length-1 - i;
            while (count > 0) {
                red = red.append(0);
                count--;
            }
            result = addStrings(result, red.toString());
        }

        return result + "";
    }

    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }


}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
