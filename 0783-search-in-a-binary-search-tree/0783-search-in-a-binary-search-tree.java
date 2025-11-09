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

 // recurrsive approach
// class Solution {
//     public TreeNode searchBST(TreeNode root, int val) {

// // first we write the condition of the if root.val == val then return root and then recurrsive call it, as the condition is match 
//         if(root == null){
//             return null;
//         }

//         if(root.val == val){
//             return root;
//         }

//         if(root.val < val){
//             return searchBST(root.right, val);
//         }
//         else{
//             return searchBST(root.left, val);
//         }
//     }

// }

// iterative approach

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val == val) return curr;
            if (val > curr.val) curr = curr.right;
            else curr = curr.left;
        }
        return null;
    }
}