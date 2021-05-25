package com.leetcode.topic51_100;

import com.leetcode.TreeNode;

/**
 * @author knight
 * @version v1.0.0
 * @Package : com.leetcode.topic51_100
 * @Description : 相同的树
 * @Create on : 2021/5/25 22:12
 **/
public class Problem100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
