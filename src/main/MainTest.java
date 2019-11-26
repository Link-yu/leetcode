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
        int[] words = {10,1,2,7,6,1,5};
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
//        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(5);
        MainTest m = new MainTest();
        System.out.println(m.combinationSum2(words,8));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        helper(candidates,target, 0, list);
        return listList;
    }

    public void helper(int[] candidates, int target, int start, List<Integer> list) {
        if (target == 0) {
            listList.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <  candidates.length;i++) {
            if (target < candidates[i]) {
                break;
            }
            List<Integer> lists = new ArrayList<>(list);
            list.add(candidates[i]);
            helper(candidates, target - candidates[i], i+1, list);
            list = lists;
            while(i+1 < candidates.length && candidates[i+1] == candidates[i]) {
                i++;
            }
        }
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
