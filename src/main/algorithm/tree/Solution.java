package main.algorithm.tree;

import sun.reflect.generics.tree.Tree;

import java.math.BigDecimal;
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
public class Solution {
    private static final double PI = 3.1415926535897932384626;
    private static final double A = 6378245.0;
    private static final double EE = 0.00669342162296594323;
    private static final int DEFAULT_SCALE = 6;
    private static final int DEFAULT_ROUND_MODE = BigDecimal.ROUND_HALF_UP;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(4);
//    List<Integer> list = postTraversal(root);
//    list.forEach(num -> {
//        System.out.println(num);
//    });
        System.out.println(maxDepth(root));
    }

    //中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode temp = stack.pop();
                res.add(temp.val);
                p = temp.right;
            }
        }
        return res;
    }

    //二叉树的最大深度，递归
    public static int maxDepth(TreeNode root) {
        return maxDepthP(root);
    }
    public static int maxDepthP(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepthP(root.left), maxDepthP(root.right)) + 1;
        }
    }


    //二叉树的最大深度，非递归;
    public static int intMaxDepth(TreeNode root) {

    }


    //前序遍历
    public static List<Integer> preTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(!stack.isEmpty() ||  p != null) {
            if (p != null) {
                res.add(p.val);
                stack.push(p);
                p = p.left;
            } else {
                TreeNode temp = stack.pop();
                p = temp.right;
            }
        }
        return res;
    }
    //后序遍历
    public static List<Integer> postTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur,pre = null;
        stack.push(root);
        while(!stack.isEmpty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                res.add(cur.val);
                stack.pop();
                pre = cur;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }

                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        return res;
    }


    //层次遍历
    public static List<Integer> levelOrderTraverse(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = null;
        stack.push(root);
        while(!stack.isEmpty()) {
            cur = stack.pop();
            res.add(cur.val);

            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return res;
    }

    public static void gcj02towgs84(double lng,double lat) {
        if (outOfChina(lng, lat)) {
            return;
        }
        else {
            double dlat = transformLat(lng - 105.0, lat - 35.0);
            double dlng = transformLon(lng - 105.0, lat - 35.0);
            double radlat = lat / 180.0 * PI;
            double magic = Math.sin(radlat);
            magic = 1 - EE * magic * magic;
            double sqrtmagic = Math.sqrt(magic);
            dlat = (dlat * 180.0) / ((A * (1 - EE)) / (magic * sqrtmagic) * PI);
            dlng = (dlng * 180.0) / (A / sqrtmagic * Math.cos(radlat) * PI);
            double mglat = lat + dlat;
            double mglng = lng + dlng;
            System.out.println(formatDouble(lng*2-mglng) + " " +formatDouble(lat*2-mglat));
        }
    }

    public static boolean outOfChina(double lon, double lat) {
        if (lon < 72.004 || lon > 137.8347) {
            return true;
        }
        if (lat < 0.8293 || lat > 55.8271) {
            return true;
        }
        return false;
    }
    private static double formatDouble(double in) {
        return round(in, DEFAULT_SCALE, DEFAULT_ROUND_MODE);
    }

    private static double round(double value, int scale, int roundingMode) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(scale, roundingMode);
        double d = bd.doubleValue();
        bd = null;
        return d;
    }

    private static double transformLat(double x, double y) {
        double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * PI) + 20.0 * Math.sin(2.0 * x * PI)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(y * PI) + 40.0 * Math.sin(y / 3.0 * PI)) * 2.0 / 3.0;
        ret += (160.0 * Math.sin(y / 12.0 * PI) + 320 * Math.sin(y * PI / 30.0)) * 2.0 / 3.0;
        return ret;
    }

    private static double transformLon(double x, double y) {
        double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * PI) + 20.0 * Math.sin(2.0 * x * PI)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(x * PI) + 40.0 * Math.sin(x / 3.0 * PI)) * 2.0 / 3.0;
        ret += (150.0 * Math.sin(x / 12.0 * PI) + 300.0 * Math.sin(x / 30.0 * PI)) * 2.0 / 3.0;
        return ret;
    }


}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
