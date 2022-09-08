package com.star.linkedlist;

import com.star.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入:[1,2,3,null,5,null,4]
 * 输出:[1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 03-15-2021 20:13
 */
public class BinaryTreeRightSideView199 {

    /**
     * 层序遍历，并只保留每层最后一个节点的值
     */
    public List<Integer> rightSideView(TreeNode root) {
        int cnt = 0, tmp = 0;
        TreeNode node;
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);

        while (!list.isEmpty()) {
            cnt = list.size();
            while (cnt > 0) {
                node = list.poll();
                if (node.left != null) {
                    list.offer(node.left);
                }
                if (node.right != null) {
                    list.offer(node.right);
                }
                cnt--;
                tmp = node.val;
            }
            res.add(tmp);
        }
        return res;
    }

}
