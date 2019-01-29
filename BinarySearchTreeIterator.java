package grace.shuati;

import java.util.Stack;

public class BinarySearchTreeIterator {
    private TreeNode cur;
    private Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root) {
        // do intialization if necessary
        cur = root;
        stack = new Stack<>();
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        if (!stack.isEmpty() || cur != null) return true;
        return false;
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        TreeNode next = cur;
        cur = cur.right;
        return next;
    }

}
