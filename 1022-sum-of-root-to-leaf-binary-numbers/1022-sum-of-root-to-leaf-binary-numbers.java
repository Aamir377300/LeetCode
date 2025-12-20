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
    public int sumRootToLeaf(TreeNode root) {
        int ans = dfs(root,0);
        return ans;
    }

    private int dfs(TreeNode root, int current){
        if(root == null) return 0;

        // building the binary number
        current = current *2 + root.val;

        // agar leaf node pr puch gaye then return the binary number
        if(root.left == null && root.right == null){
            return current;
        }

        return dfs(root.left, current) + dfs(root.right, current);
    }
}