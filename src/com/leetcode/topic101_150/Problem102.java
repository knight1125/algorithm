package com.leetcode.topic101_150;

import com.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author knight
 * @version v1.0.0
 * @Package : com.leetcode.topic101_150
 * @Description :  二叉树的层次遍历,  核心(队列先进先出)
 * @Create on : 2021/5/25 21:25
 **/
public class Problem102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // 要对 [] 返回 []
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size -- > 0) {
                TreeNode currentNode = queue.remove();
                // 对当前节点的操作
                list.add(currentNode.val);
                // 左右孩子入队
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Problem102().levelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));
        res.stream().forEach(
                (list) -> list.stream().forEach(System.out::println)
        );

    }
}
