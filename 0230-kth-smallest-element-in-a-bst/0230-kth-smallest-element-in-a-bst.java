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

// map me dal de with the first as the indexed which is act as the k and the second as there element of the list 
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<lt.size(); i++){
            mp.put(i+1,lt.get(i)); // i+1 due to 1-indexed rule
        }

        // get the answer from the map as i put the k things
        return mp.get(k);
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        lt.add(root.val);
        inorder(root.right);
    }
}