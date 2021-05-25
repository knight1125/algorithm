package com.leetcode;

/**
 * @author knight
 * @version v1.0.0
 * @Package : com.leetcode
 * @Description : 树的节点定义
 * @Create on : 2021/5/25 21:23
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode () {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
