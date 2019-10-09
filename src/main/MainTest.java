package main;

import java.util.*;

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
        int[] nums1 = {1,2,7};
        int[] nums2 = {3,4};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] nums = new int[length];
        for (int i = 0; i < nums1.length;i++) {
            nums[i] = nums1[i];
        }

        for (int j = 0; j < nums2.length;j++) {
            nums[nums1.length+j] = nums2[j];
        }

        Arrays.sort(nums);
        if (length%2 == 0) {
            return (double)(nums[length/2-1] + nums[length/2])/2;
        } else {
            return  (double)nums[length/2];
        }
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
