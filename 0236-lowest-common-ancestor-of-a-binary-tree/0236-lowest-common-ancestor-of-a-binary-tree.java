/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//  the depest ancenstor is known as the LCA 
// https://www.youtube.com/watch?v=_-QHfMDde90

// class Solution {

//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

//         // BASE CASE
//         if (root == null || root == p || root == q) {
//             return root;
//         }

//         TreeNode left = lowestCommonAncestor(root.left, p, q);
//         TreeNode right = lowestCommonAncestor(root.right, p, q);

//         if (left == null) {
//             return right;
//         } else if (right == null) {
//             return left;   
//         } else { // if both are null then we get our values
//             return root;
//         }
//     }
// }

// Brute approach

// 	1.	Find the path from root to p
//	2.	Find the path from root to q
//	3.	Compare both paths from the beginning
//	4.	The last common element is the LCA

class Solution {

    // Method to find path from root to a given node
    private boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) return false;

        path.add(root);

        if (root == target) return true;

        if (findPath(root.left, target, path) || findPath(root.right, target, path))
            return true;

        path.remove(path.size() - 1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        findPath(root, p, path1);
        findPath(root, q, path2);

        int i = 0;
        TreeNode lca = null;

        // Compare paths
        while (i < path1.size() && i < path2.size()) {
            if (path1.get(i) != path2.get(i))
                break;
            lca = path1.get(i);
            i++;
        }

        return lca;
    }
}