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
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {3,4};
        char[][] b = new char[2][3];
        String[] strs = {"flower","flow","flight"};
        System.out.println(solution.threeSum(nums1));
        System.out.println(strs[0].indexOf(strs[1]));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length;i++) {
            List<Integer> list = new ArrayList<>();
            int target = 0 - nums[i];
            list.add(nums[i]);
            twoSum(nums, i, target, list);
            if (list.size() == 3) {
                lists.add(list);
            }
        }

        return lists;
    }

    public void twoSum(int[] nums, int out, int target, List<Integer> tmp) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = out; i < nums.length;i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                tmp.add(nums[map.get(temp)]);
                tmp.add(nums[i]);
            } else {
                map.put(nums[i],i);
            }
        }
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
