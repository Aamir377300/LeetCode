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

// https://www.notion.so/105-Construct-Binary-Tree-from-Preorder-and-Inorder-Traversal-280a03f3fefa80df8749c226ba9c3724


 // preorder(NLR) ka first element told us about the Root but then we do not know the which is left and right join with the root node, the inorder come here due to root ka node kojo us ke left me left subtree me hoga and us ke right wala right subtree me hoga and ye ysi trah for all use 

// preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]

// using the preorder 3 is root node, then search 3 in inorder, {so the before 3 is left subtree part and after are right subtree part}. 9 comes to left subtree and then 20 comes to the right of the main node{the problem is 20 ke right and left me kun kun hoga? this is done using inorder: 20 in inorder ke left me wala left subtree and right me wala right subtree}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map <Integer, Integer> Imap = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            Imap.put(inorder[i], i);
        }

        return splitTree(preorder, Imap, 0, 0, inorder.length-1);
    }


    private TreeNode splitTree(int[] preorder, Map<Integer, Integer> Imap, int rootIndex, int left, int right){ // inorder ke left and right wala

        TreeNode root = new TreeNode(preorder[rootIndex]);

        // this get you the root index in the inorder array
        int mid = Imap.get(preorder[rootIndex]); // eg1: mid = 1

        if(mid> left){ // agar mid bada hai left subtree bano(1>0)
            root.left = splitTree(preorder, Imap, rootIndex + 1, left, mid-1); //{mid-1 due to the agar -1 nahi kiya then we have to problem like hamse left hi excute hoga right ki baari hi nahi aayegi}
        }

        if(mid< right){
            root.right = splitTree(preorder, Imap, rootIndex + mid-left+1, mid+1, right);
        }

        return root;
    }
}