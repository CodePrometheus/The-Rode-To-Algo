package com.star.tree;

import com.star.common.ArrayToTreeNode;
import com.star.common.TreeNode;

/**
 * 打印二叉树中某一层的节点 从右往左
 *
 * @Author: Starry
 * @Date: 01-04-2023
 */
public class PrintNLevelTreeNode {
    static void nLevel(TreeNode node, int level) {
        if (node == null) return;
        if (level == 1) System.out.print(node.val + " ");
        else {
            nLevel(node.right, level - 1);
            nLevel(node.left, level - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = ArrayToTreeNode.arrayToTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        nLevel(root, 3);
    }
}
