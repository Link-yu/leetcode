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
        solution.generateParenthesis(1);
        System.out.println(strs[0].substring(0, strs[0].length()-1));
    }

    public List<String> generateParenthesis(int n) {
        if(n<=0){
            return null;
        }
        ArrayList<String>	list = new ArrayList<String>();
        String str = new String();
        dfs(list,str,n,n);
        return list;
    }

    private void dfs(ArrayList<String> list, String str, int left, int right){
        if(left>right)	{
            return;//problem with ")("
        }
        if(left==0&&right==0){
            list.add(str);
            return;
        }
        if(left>0){
            dfs(list,str+"(",left-1,right);
        }
        if(right>0){
            dfs(list, str+")",left,right-1);
        }
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
