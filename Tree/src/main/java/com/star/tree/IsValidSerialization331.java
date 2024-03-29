package com.star.tree;

import org.junit.Test;

/**
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 * <p>
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 * <p>
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * <p>
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * <p>
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如"1,,3" 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例2:
 * <p>
 * 输入: "1,#"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: "9,#,#,1"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 03-12-2021 07:48
 */
public class IsValidSerialization331 {

    /**
     * 一个序列什么时候一定合法 首先 节点数量关系要满足 其次 遍历过程中 叶子节点不能分布不均
     * 二叉树必然 叶子节点数 = 非叶子节点数 + 1
     * 最后遍历到的必然是 # 叶子节点 叶子节点显然会出现在序列最后
     * 所以在树的先序遍历过程中 (在最后一个节点前) 叶子节点最多和非叶子节点相等
     * 如果叶子节点超过了非叶子 说明至少有一个叶子节点#上接了其他节点
     */
    public boolean isValidSerialization(String preorder) {
        // 记录叶子节点 和 总结节点数
        int leafCount = 0, nodeCount = 1;
        for (char ch : preorder.toCharArray()) {
            if (leafCount > nodeCount - leafCount) {
                return false;
            }
            if (ch == ',') {
                nodeCount++;
            }
            if (ch == '#') {
                leafCount++;
            }
        }
        return (nodeCount - leafCount) + 1 == leafCount;
    }

    /**
     * 从后往前
     * 用num记录#的个数，当遇到正常节点时，#的个数-2，并将该节点转化成#，num+1，
     * 整体即为num-1; 当出现num的个数不足2时，即false，最终也须保证num为1
     */
    public boolean isValidSerialization2(String preorder) {
        char[] array = preorder.toCharArray();
        int n = array.length;
        int num = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (array[i] == ',') {
                continue;
            }
            if (array[i] == '#') {
                num++;
            } else {
                while (i >= 0 && array[i] != ',') {
                    i--;
                }
                // 消除2个#，消除一个节点数字并转换成#
                if (num >= 2) {
                    num--;
                } else {
                    return false;
                }
            }
        }
        if (num != 1) {
            return false;
        }
        return true;
    }

    @Test
    public void isValidSerializationTest() {
        String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(isValidSerialization(s));
        System.out.println(isValidSerialization2(s));
    }

}
