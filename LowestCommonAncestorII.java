package grace.shuati;
import java.util.*;

public class LowestCommonAncestorII {
    class ParentTreeNode {
        public ParentTreeNode parent, left, right;
    }
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        List<ParentTreeNode> pathA = getPathToRoot(A);
        List<ParentTreeNode> pathB = getPathToRoot(B);

        int indexA = pathA.size() - 1;
        int indexB = pathB.size() - 1;
        ParentTreeNode lowestCommonAncestor = null;

        while (indexA >= 0 && indexB >= 0) {
            if (pathA.get(indexA) != pathB.get(indexB)) {
                break;
            }
            lowestCommonAncestor = pathA.get(indexA);
            indexA--;
            indexB--;
        }
        return lowestCommonAncestor;
    }

    private List<ParentTreeNode> getPathToRoot(ParentTreeNode node) {
        List<ParentTreeNode> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        return path;
    }
}
