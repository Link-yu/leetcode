package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        int[] nums = {2, 7, 11, 15};
        System.out.println(solution.twoSum2(nums,9));
    }

    //
    public int[] twoSum2(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] {map.get(temp), i};
            } else {
                map.put(nums[i],i);
            }
        }
        return result;

    }

}
