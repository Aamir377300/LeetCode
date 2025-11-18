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
 
import java.util.*;

//using queue
// class Solution {
//     public void flatten(TreeNode root) {
//         if (root == null) return;
//         Queue <TreeNode> q = new LinkedList<>();
//         preorder(root, q);

//         root.left = null;
// root.right = null;

//         q.poll();
//         while(!q.isEmpty()){
//             TreeNode next = q.poll();
//             root.left = null;
//             root.right = next;
//             root = root.right;
//         }
//     }

//     private void preorder(TreeNode root, Queue<TreeNode> q) {
//         if (root == null) return;

//         q.add(root);
//         preorder(root.left, q);
//         preorder(root.right, q);
//     }
// }

// using stack
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode curr = st.pop();

            // Push right child first → so left child is processed first (preorder)
            if (curr.right != null) {
                st.push(curr.right);
            }

            // Push left child
            if (curr.left != null) {
                st.push(curr.left);
            }

            // If stack still has nodes, connect curr.right to next node
            if (!st.isEmpty()) {
                curr.right = st.peek();
            }

            // Left must always be null (linked list format)
            curr.left = null;
        }

    }
}