package grace.shuati;
import java.util.*;

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        TreeNode curNode = stack.peek();
        TreeNode node = curNode;
        // curNode is the smallest node currently
        // find the next node in the tree
        // use node to make sure the next node is on the top of the stack (just an intermediate node)
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        } else {
            // when node.right is null, need to find its parent where node is its left child
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().right == node) {
                node = stack.pop();
            }
        }

        return curNode;
    }
}
