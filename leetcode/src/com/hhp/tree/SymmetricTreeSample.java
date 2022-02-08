package com.hhp.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTreeSample {

    public boolean isSymmetric(TreeNode root) {
        // 创建一个队列辅助判断
        Queue<TreeNode> q = new LinkedList<>();
        // 定义左右子树指针
        TreeNode u = root.left;
        TreeNode v = root.right;
        // 空树或者只含有根节点，当然是对称结构了
        if (root == null || (u == null && v == null)) {
            return true;
        }
        // 左右子树入队
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            // 左右子树出队
            u = q.poll();
            v = q.poll();
            // 都为空跳过判断
            if (u == null && v == null) {
                continue;
            }
            // 其中一个子树为空或者两个不为空的子树但值不相等
            if (u == null || v == null || (u.val != v.val)) {
                return false;
            }

            // 左子树左孩子
            q.offer(u.left);
            // 右子树右孩子
            q.offer(v.right);

            // 左子树右孩子
            q.offer(u.right);
            // 右子树左孩子
            q.offer(v.left);
        }
        // 队列为空说明是对称二叉树
        return true;
    }
}
