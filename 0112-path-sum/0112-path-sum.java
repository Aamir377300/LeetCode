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
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // Base Case: Check if it's a leaf node AND the current node's value 
        // equals the remaining target sum.
        if (root.left == null && root.right == null) {
            if(root.val == targetSum){
                return true;
            }
            else{
                return false;
            }
        }

        // Recursive Step: Subtract the current node's value and search in subtrees.
        int remainingSum = targetSum - root.val;

        // Check left OR right subtree.
        return hasPathSum(root.left, remainingSum) || 
               hasPathSum(root.right, remainingSum);
    }
}