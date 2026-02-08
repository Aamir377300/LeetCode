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

 // balanced subtree is defined as for every node |height of left subtree - height of right subtree| <= 1; // 1 se jada nahi hona chaiye
class Solution {
    public boolean isBalanced(TreeNode root) {
        int ans = Height(root);

        if(ans == -1){
            return false;
        }
        else{
            return true;
        }
        
    }

    public boolean Height(TreeNode root) {
        if (root == null) return false;

        int leftHt = Height(root.left);
        if (leftHt == -1) return -1; // \U0001f448 it helps for some edges cases

        int rightHt = Height(root.right);
        if (rightHt == -1) return -1; // \U0001f448 it helps for some edges cases

        if (Math.abs(leftHt - rightHt) > 1) return -1;

        return Math.max(leftHt, rightHt) + 1; // we need to return the height because it is check above, this is recurrsion so it is going to use in the above when the recurrsion take place.
    }
}