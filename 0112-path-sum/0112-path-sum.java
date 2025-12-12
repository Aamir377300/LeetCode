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
 // leaf node jis ka koi child na ho
 // question is asking, start from any node and go till the leaf node and sum of that is equal to targetSum then true otherwise false
class Solution {
    int target;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        target = targetSum; // helper ko targetSum use karna hai but we are unable to do it directly so we make a global variable and then use it

        return helper(root, 0);
        
    }

    private boolean helper(TreeNode root, int Csum){
        if(root == null){
            return false;
        }

        Csum = Csum + root.val;

        // check if the root has leaf node
        if(root.left == null && root.right == null){
            return Csum == target; // if this correct return true otherwise false
        }

        boolean Lans = helper(root.left, Csum);
        boolean Rans = helper(root.right, Csum);

        return Lans || Rans;

    }
}