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
    int sum =0;
    public TreeNode bstToGst(TreeNode root) {
        convert_INTO_GST(root);
        return root;
    }

    private void convert_INTO_GST(TreeNode root){
        if(root == null) return;

        convert_INTO_GST(root.right);

        sum = sum + root.val;
        root.val = sum; // tree to us ke GST se change kr rahe hai and last me yse hi return kr dege

        convert_INTO_GST(root.left);
    }
}