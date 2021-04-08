import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序遍历。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * <p>
 * <p>
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 * <p>
 * <p>
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 04-08-2021 23:02
 */
public class InorderTraversal094 {

    /**
     * 递归
     * 左子树——根节点——右子树
     * 定义 inorder(root) 表示当前遍历到  root 节点的答案，那么按照定义，我们只要递归调用 inorder(root.left)
     * 来遍历 root 节点的左子树，然后将 root 节点的值加入答案，再递归调用inorder(root.right) 来遍历 root 节点的右子树即可，
     * 递归终止的条件为碰到空节点。
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        order(root, res);
        return res;
    }

    public void order(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        order(root.left, res);
        res.add(root.val);
        order(root.right, res);
    }

    /**
     * 迭代
     * 栈
     * 递归的调用过程是不断往左边走，当左边走不下去了，就打印节点，并转向右边，然后右边继续这个过程。
     * 我们在迭代实现时，就可以用栈来模拟上面的调用过程。
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        // root为空且stack为空，遍历结束
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 此时root==null，说明上一步的root没有左子树
            // 1. 执行左出栈。因为此时root==null，导致root.right一定为null
            // 2. 执行下一次外层while代码块，根出栈。此时root.right可能存在
            // 3a. 若root.right存在，右入栈，再出栈
            // 3b. 若root.right不存在，重复步骤2

            // 最左的 当前节点为空，说明左边走到头了，从栈中弹出节点并保存
            root = stack.pop();
            res.add(root.val);
            // 然后转向右边节点，继续上面整个过程
            root = root.right;
        }
        return res;
    }

}
