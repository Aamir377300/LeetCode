/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// har node ki taraf jao and ys me se ys ka node value subtract with the targetSum and if in the last (leaf node), if root value and targetSum sum is same then true or otherwise false
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        // Base case
        if (root == null) return false;

        // If leaf node, check sum
        if (root.left == null && root.right == null) { // leaf node case (above mention)
            return targetSum == root.val;
        }

        // Recur for left and right
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);

        return left || right;
    }
}