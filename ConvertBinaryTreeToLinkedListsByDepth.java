package grace.shuati;
import java.util.*;

public class ConvertBinaryTreeToLinkedListsByDepth {

    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
          }
    }
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        // queue - BFS
        // put the root to the queue
        // while queue is not empty, poll, add left and right to the queue, since this is level-based, need size
        Queue<TreeNode> queue = new LinkedList<>();
        List<ListNode> res = new ArrayList<>();

        if (root == null) return res;
        queue.offer(root);


        ListNode dummy = new ListNode(0);
        ListNode lastNode = null;
        while (!queue.isEmpty()) {
            dummy.next = null;
            lastNode = dummy;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                lastNode.next = new ListNode(head.val);
                lastNode = lastNode.next;

                if (head.left != null)
                    queue.offer(head.left);
                if (head.right != null)
                    queue.offer(head.right);
            }
            res.add(dummy.next);
        }
        return res;
    }
}
