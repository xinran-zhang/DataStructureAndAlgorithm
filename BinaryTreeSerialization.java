package grace.shuati;

import java.util.LinkedList;
import java.util.*;

public class BinaryTreeSerialization {
    public class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
         this.val = val;
         this.left = this.right = null;
        }
    }

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // use a queue to record each node in the tree
        // use a String to record the serialization result
        if (root == null) return "{}";
        List<TreeNode> queue = new ArrayList<>();

        queue.add(root);
        // hmmm the size of the queue is changing all the time...
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) continue;
            queue.add(node.left);
            queue.add(node.right);
        }
        // remove null from the end of queue
        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }

        StringBuilder res = new StringBuilder();
        res.append("{");
        res.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                res.append(",#");
            } else {
                res.append(",");
                res.append(queue.get(i).val);
            }
        }
        res.append("}");
        return res.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */

    // what is the point of maintain a boolean isLeftChild?
    public TreeNode deserialize(String data) {
        if (data == "{}") return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}
