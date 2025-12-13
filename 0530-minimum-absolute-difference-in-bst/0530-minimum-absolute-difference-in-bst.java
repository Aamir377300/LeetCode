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
    List<Integer> lt = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {

        inorder(root);

        int minDiff = Integer.MAX_VALUE;

        for(int i=0; i<lt.size(); i++){
            for(int j=i+1; j<lt.size(); j++){
                int diff = Math.abs(lt.get(j) - lt.get(i));
                minDiff = Math.min(minDiff, diff);
            }
                
            
        }
        return minDiff;

    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        lt.add(root.val);
        inorder(root.right);
    }
}