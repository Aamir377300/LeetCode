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

        
        if(key < root.val){// left me ja
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val){// right me ja
            root.right = deleteNode(root.right, key);
        }
        else{ // root.val == key
            // if one child or no child 
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            int maxValue = MaxLeftSubtree(root);
            root.val = maxValue;

            root.left = deleteNode(root.left, maxValue);


        }

        return root;
    }

    public int MaxLeftSubtree(TreeNode root){
        root = root.left;

        while(root.right != null){
            root = root.right;
        }

        return root.val;
    }
}