/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//  the depest ancenstor is known as the LCA 
// https://www.youtube.com/watch?v=_-QHfMDde90

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // BASE CASE
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;   
        } else { // if both are null then we get our values
            return root;
        }
    }
}