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
        int[] words = {2,3,6,7};
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
//        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(5);
        MainTest m = new MainTest();
        System.out.println(m.combinationSum(words,7));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        helper(candidates,target, 0, list);
        return listList;
    }

    public void helper(int[] candidates, int target, int start, List<Integer> list) {
        if (target == 0 || start < candidates.length) {
            listList.add(list);
        }

        int tmp = target/candidates[start];
        while (tmp >= 0) {
            List<Integer> lists = new ArrayList<>();
            if (target - tmp*candidates[start] < candidates[start]) {
                continue;
            } else {
                int num = tmp;
                while(num>=0) {
                    lists.add(candidates[start]);
                }
                helper(candidates, target - tmp*candidates[start], start+1, lists);
            }
        }
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
