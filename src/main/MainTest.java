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
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int iMin = 0;
        int iMax = len1;
        while (iMin < iMax) {
            int i = (iMin + iMax)/2;
            int j = (len1+len2+1)/2-i;

            if (i < iMax && nums2[j-1] > nums1[i]) {
                iMin = iMin + 1;
            } else if (i > iMin && nums1[i-1] > nums2[j]) {
                iMax = iMax - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j-1];
                } else if (j == 0) {
                    maxLeft = nums1[i-1];
                } else {
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }

                if ((len1 + len2) % 2 ==1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == len1) {
                    minRight = nums2[j];
                } else if (j == len2) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                return (minRight + maxLeft)/2.0;
            }
        }
        return 0.0;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
