import java.io.File;
import java.util.Arrays;

/**
 * Created on 2017/7/17.
 * Title: Simple
 * Description: Example
 * Copyright: Copyright(c) 2016
 * Company: 杭州公共交通云科技有限公司
 *
 * @author 维斯
 */
public class Solution {
    int[] result = new int[2];
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        System.out.println(solution.twoSum2(nums,9));
    }

    //递归
    public int[] twoSum2(int[] nums, int target) {

        Arrays.sort(nums);
        method(nums, target,0,0);
        return result;

    }

    public void method(int[] nums, int target,int start, int t) {
        if (target == 0) {
            result[0] = start;
            result[1] = t;
            return;
        }

        for (int i = t; i < nums.length; i++) {
            if (nums[i] >= target && i == 0) {
                continue;
            }
            int temp = target-nums[i];
            method(nums, temp, start, i+1);
        }
    }
    //双
    public int[] twoSum(int[] nums, int target) {
        //先排序
        int[] result = new int[2];
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] == target) {
                result[0] = left;
                result[1] = right;
                break;
            } else {
                left++;
            }
        }
        return result;
    }
}
