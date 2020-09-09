package main;



import main.algorithm.tree.TrieTree;

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
    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
        String[] dic = {"looked","just","like","her","brother"};
        String[] str = {"time", "be", "bell","atime"};
        System.out.println(mainTest.minimumLengthEncoding3(str));
//        System.out.println("1314141".replace("13",""));
//        System.out.println(mainTest.respace(dic,"jesslookedjustliketimherbrother"));
//        for (int i = 0; i < temp.length;i++) {
//            System.out.println(temp[i]);
//        }
    }
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words);
        StringBuffer temp = new StringBuffer("#");
        for (int i = 0; i < words.length; i++) {
            temp.append(words[i]+ "#");
        }

        String result = temp.toString();
        for(int i = 0; i < words.length;i++) {
            //同时包含
            if (result.indexOf("#" + words[i] + "#") > -1 && result.lastIndexOf(words[i] + "#") != result.indexOf(words[i] + "#")) {
                result = result.replace("#" + words[i] + "#", "#");
            }
        }

        return result.length()-1;
    }

    public int minimumLengthEncoding3(String[] words) {
        TrieNode trieNode = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode cur = trieNode;
            for (int j = word.length()-1; j >=0; j--) {
                cur = cur.get(word.charAt(j));
            }
            nodes.put(cur, i);
        }

        int result = 0;
        for (TrieNode node:nodes.keySet()) {
            if (node.count == 0) {
                //count=0 表示叶子节点
                result+=words[nodes.get(node)].length() +1;
            }
        }
        return result;
    }

    class TrieNode{
        TrieNode[] children;
        int count;
        TrieNode() {
            children = new TrieNode[26];
            count =0;
        }

        public TrieNode get(char c) {
            if (children[c-'a'] == null) {
                children[c-'a'] = new TrieNode();
                count++;
            }
            return children[c-'a'];
        }
    }
    public int minimumLengthEncoding2(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word:words) {
            for (int i = 1; i < word.length();i++) {
                if (set.contains(word.substring(i))) {
                    set.remove(word.substring(i));
                }
            }
        }
        int result = 0;
        for (String word:set){
            result = word.length() + result +1;
        }
        return result;
    }



    public int respace(String[] dictionary, String sentence) {
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int idx = 0; idx < i; idx++) {
                if (dict.contains(sentence.substring(idx, i))) {
                    dp[i] = Math.min(dp[i], dp[idx]);
                }
            }
        }
        return dp[n];
    }


    public int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length;i++) {
            int temp = calOne(arr[i]);
            if (!map.containsKey(temp)) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                map.put(temp, list);
            } else {
                map.get(temp).add(arr[i]);
            }
        }
        int[] nums = new int[map.size()];
        int i = 0;
        for (Integer temp:map.keySet()) {
            nums[i++] = temp;
        }
        Arrays.sort(nums);
        int k = 0;
        for (int j = 0; j < nums.length;j++) {
            List<Integer> ll = map.get(nums[j]);
            Collections.sort(ll);
            for (Integer l:ll) {
                result[k++] = l;
            }
        }
        return result;
    }

    public int calOne(int num) {
        int result = 0;
        while (num > 0) {
            if (num%2 == 1) {
                result++;
            }
            num = num/2;
        }
        return result;
    }
    //归并排序
    public int[] mergeSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int mid = nums.length/2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public int[] merge(int[] left, int[] right) {
        int[] nums = new int[left.length+ right.length];

        for (int index = 0, i = 0, j = 0; index< nums.length;index++) {
            if (i >= left.length) {
                nums[index] = right[j++];
            } else if (j >= right.length) {
                nums[index] = left[i++];
            } else if(left[i] <= right[j]) {
                nums[index] = left[i++];
            } else if(left[i] > right[j]) {
                nums[index] = right[j++];
            }
        }
        return nums;
    }

    //快速排序
    public void quickSort2(int[] array, int start, int end) {
        if (start > end) {
            return;
        }
        int i = start;
        int j = end;
        int temp = array[start];
        while (i < j) {
            while(temp<= array[j]&& i<j) {
                j--;
            }
            while(temp>= array[i] && i < j) {
                i++;
            }
            //如果找到array[i] 大于temp，array[j] 小于temp，则交换
            if(i<j) {
                swap(i, j, array);
            }
        }
        swap(start, i, array);
        quickSort2(array, start, i-1);
        quickSort2(array, i+1, end);
    }
    public int[] QuickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            QuickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            QuickSort(array, smallIndex + 1, end);
        return array;
    }
    /**
     * 快速排序算法——partition
     * @param array
     * @param start
     * @param end
     * @return
     */
    public int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(pivot, end, array);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(i, smallIndex,array);
            }
        return smallIndex;
    }



    // 冒泡排序
    public void buppleSort(int[] nums) {
        for(int i = 0; i < nums.length;i++) {
            for (int j = 0; j < nums.length-1-i;j++) {
                if (nums[j] > nums[j+1]) {
                    swap(j, j+1,nums);
                }
            }
        }
    }
    // 这个是针对插入排序来优化
    public void shellSort(int[] nums) {
        int h = nums.length/2;
        while (h >= 1) {
            for (int i = h; i < nums.length;i++) {
                for (int j = i; j >= h ;j= j-h) {
                    if (nums[j] < nums[j-h]){
                        swap(j,j-h, nums);
                    }
                }
            }
            h = h/2;
        }
    }
    public void insertSort2(int[] nums) {
        for (int i = 1; i < nums.length;i++) {
            for (int j = i; j > 0;j--) {
                if (nums[j] < nums[j-1]) {
                    swap(j, j-1,nums);
                }
            }
        }
    }

    public void insertSort(int[] nums) {
        for (int i = 1; i < nums.length;i++) {
            if (nums[i] >= nums[i-1]) {
                continue;
            } else {
                for(int j = i; j>0;j--) {
                    if (nums[j]<nums[j-1]) {
                        swap(j,j-1,nums);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public void choseSort(int[] nums) {
        //选择排序
        int minIndex = 0;
        for (int i = 0; i < nums.length;i++) {
            minIndex = i;
            for (int j = i+1; j < nums.length;j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex,nums);
        }
    }


    public void swap(int one, int two, int[] nums) {
        int temp = nums[one];
        nums[one] = nums[two];
        nums[two] = temp;
    }




    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return climbStairs(n-1) + climbStairs(n-2) ;
    }

    public int climbStairs2(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        Long right = Long.valueOf(x);
        Long left = 1L;
        Long mid = (right +left)/2;
        while (right -left > 1) {
            Long temp = mid*mid;
            if (temp > x) {
                right = mid;
            } else if(temp < x) {
                left = mid;
            } else {
                return mid.intValue();
            }
            mid = (right + left) /2;
        }
        return left.intValue();
    }

    public String addBinary(String a, String b) {
        int lenA = a.length()-1;
        int lenB = b.length()-1;
        int temp = 0;
        String result = "";
        int atemp = 0;
        int btemp =0 ;
        while (lenA >= 0 || lenB >= 0) {
            if (lenA >= 0) {
                atemp = Integer.valueOf(a.charAt(lenA) + "");
            }

            if (lenB >= 0) {
                btemp = Integer.valueOf(b.charAt(lenB) + "");
            }
            int plus = btemp + atemp + temp;
            if (plus <= 1) {
                result = plus + result;
                temp = 0;
            } else if (plus == 2) {
                result = 0 + result;
                temp = 1;
            } else {
                result = 1 + result;
                temp = 1;
            }
            lenA--;
            lenB--;
            atemp = 0;
            btemp = 0;
        }
        if (temp == 1) {
            result = 1 + result;
        }

        return result;
    }

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length<= 1) {
            return false;
        }
        Arrays.sort(deck);
        boolean flag = false;
        for (int x = 2; x <= deck.length;x++) {
            if (deck.length%x != 0) {
                continue;
            }
            flag = false;
            for (int i= 0; i<= deck.length-x;i=i+x) {
                if (deck[i] != deck[i+x-1]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return true;
            }
        }
        return false;
    }
}
