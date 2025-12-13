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

// https://www.notion.so/108-Convert-Sorted-Array-to-Binary-Search-Tree-280a03f3fefa808e8dd7fc16877ae590


// we put the middle element as the root due to they have been in the sorted(inorder) so the middle be the root and its left side remain element as left subtree and same on the right side as right subtree

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length-1);
    }

    private TreeNode buildBST(int[] nums, int left, int right){
        if(left > right){
            return null;
        }

        int mid = left +(right-left)/2;
        
        // defining the root
        TreeNode root = new TreeNode(nums[mid]);

        // define the left and right subtree
        root.left = buildBST(nums, left, mid-1);
        root.right = buildBST(nums, mid+1, right);


        return root;

    }
}