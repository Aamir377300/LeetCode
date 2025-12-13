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
// kthSmallest means like if the k=3 then the 3 smallest in the BST

class Solution {
    List<Integer> lt = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);

        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<lt.size(); i++){
            mp.put(i+1,lt.get(i));
        }

        return mp.get(k);
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        lt.add(root.val);
        inorder(root.right);
    }
}