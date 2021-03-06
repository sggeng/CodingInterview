package binary_tree_longest_consecutive_sequence;

/**
 * Created by Xiaotian on 2/17/18.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    // top down
    // tag: dfs
    // time: O(n)
    // space: O(1)
    int maxLen;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        maxLen = 0;
        dfs(root, null, 0);
        return maxLen;
    }


    private void dfs(TreeNode root, TreeNode parent, int currLen) {
        if (root == null) return;

        currLen = (parent != null && root.val == parent.val + 1) ? currLen + 1 : 1;
        maxLen = Math.max(maxLen, currLen);
        dfs(root.left, root, currLen);
        dfs(root.right, root, currLen);
    }
}

class SolutionII {
    // bottom up
    // tag: dfs
    // time: O(n)
    // space: O(1)
    int maxLen;
    public int longestConsecutive(TreeNode root) {
        maxLen = 0;
        dfs(root);
        return maxLen;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int lenL = 0;
        if (root.left != null) {
            lenL = dfs(root.left);
            if (root.val + 1 != root.left.val) lenL = 0;
        }
        int lenR = 0;
        if (root.right != null) {
            lenR = dfs(root.right);
            if (root.val + 1 != root.right.val) lenR = 0;
        }
        int currMaxLen = Math.max(lenL, lenR) + 1;
        maxLen = Math.max(maxLen, currMaxLen);
        return currMaxLen;
    }

}
