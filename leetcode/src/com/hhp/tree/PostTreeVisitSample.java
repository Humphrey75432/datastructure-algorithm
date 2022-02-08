package com.hhp.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostTreeVisitSample {

    public List<Integer> postOrderTraversal(TreeNode root) {
        // 保存二叉树的遍历结果
        List<Integer> res = new ArrayList<>();
        // 借助栈实现非递归方式
        Stack<TreeNode> stack = new Stack<>();
        // 用于回溯带右子树的节点
        TreeNode prevAccess = null;
        while (root != null || !stack.isEmpty()) {
            // 一直把左子树压入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 取完左子树后取栈顶元素
            root = stack.pop();
            // 如果没右子树，或者找到该节点的右子树则写入结果
            if (root.right == null || root.right == prevAccess) {
                res.add(root.val);
                prevAccess = root;
                root = null;
            } else {
                // 重新将该店压回栈中，并且记录下右子树的位置
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
