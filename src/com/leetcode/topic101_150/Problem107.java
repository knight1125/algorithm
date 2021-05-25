package com.leetcode.topic101_150;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author knight
 * @version v1.0.0
 * @Package : com.leetcode.topic101_150
 * @Description :  二叉树层序遍历二
 * @Create on : 2021/5/25 21:47
 **/
public class Problem107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                while(size-- > 0) {
                    TreeNode currentNode = queue.remove();
                    list.add(currentNode.val);
                    if (currentNode.left != null) queue.add(currentNode.left);
                    if (currentNode.right != null) queue.add(currentNode.right);
                }
                res.add(0, list);
            }
        }
        return res;


    }


}
