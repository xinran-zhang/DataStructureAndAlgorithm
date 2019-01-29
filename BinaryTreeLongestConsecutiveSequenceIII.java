package grace.shuati;
import javax.xml.transform.Result;
import java.util.*;

public class BinaryTreeLongestConsecutiveSequenceIII {
    public class MultiTreeNode {
        int val;
        List<MultiTreeNode> children;
        MultiTreeNode(int x) {
            val = x;
        }
    }

    class ResultType {
        int maxLength, maxUp, maxDown;
        public ResultType(int len, int up, int down) {
            maxLength = len;
            maxUp = up;
            maxDown = down;
        }
    }

    public int longestConsecutive3(MultiTreeNode root) {
        return helper(root).maxLength;
    }

    private ResultType helper (MultiTreeNode root) {
        if (root == null) {
            return new ResultType(0, 0 , 0);
        }

        int up = 0;
        int down = 0;
        int maxLen = 1;
        for (MultiTreeNode node: root.children) {
            ResultType type = helper(node);
            if (node.val + 1 == root.val) {
                down = Math.max(down, type.maxDown + 1);
            }
            if (node.val - 1 == root.val) {
                up = Math.max(up, type.maxUp + 1);
            }
            maxLen = Math.max(maxLen, type.maxLength);
        }

        maxLen = Math.max(maxLen, up + down + 1);
        return new ResultType(maxLen, up, down);
    }
}
