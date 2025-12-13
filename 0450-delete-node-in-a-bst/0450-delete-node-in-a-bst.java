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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
// left < root < right
        if(key < root.val){ // 
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else{
            // if root.val == key {hamee yse hatna hoga and BST aise set karna hoga ki BST ke rule wo follow ho}

            // case1: if the one child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            // case2: if left and right child both present (tricky one (we have to remove it and transfer so the BST rule must be validate))

            int leftmaxVal = MaxLeftSubtree(root);
            root.val = leftmaxVal;

            root.left = deleteNode(root.left, leftmaxVal);
        }
        return root;
    }
    private int MaxLeftSubtree(TreeNode root){
        root = root.left;

        while(root.right != null){ // right ki taraf jaye gii kukui udhar hi max value hi hoga
            root = root.right;
        }
        return root.val;
    }
}