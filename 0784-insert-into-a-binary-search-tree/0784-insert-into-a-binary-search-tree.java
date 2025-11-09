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
//     public TreeNode insertIntoBST(TreeNode root, int val) {
//         if (root == null) {
//             return new TreeNode(val);
//         }

//         if (val < root.val) {
//             if (root.left == null) {
//                 root.left = new TreeNode(val);
//                 // agar left node ke left null nahi hai thenn we do insertIntoBST for left so it is tranverse.
//             } else {
//                 insertIntoBST(root.left, val);
//             }
//         } else {
//             if (root.right == null) {
//                 root.right = new TreeNode(val);
//             } else {
//                 insertIntoBST(root.right, val);
//             }
//         }

//         return root;
//     }
// }


// iteractive approach 

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        
        TreeNode curr = root;
        
        while(true){
            if(curr.val < val){
                if(curr.right != null) curr = curr.right;
                else {
                    curr.right = new TreeNode(val);
                    break;
                }
            }
            else{
                if(curr.left != null) curr = curr.left;
                else{
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}