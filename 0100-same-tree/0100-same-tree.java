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

//  import java.util.*;
// class Solution {
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         List <Integer> l1 = new ArrayList<>();
//         List <Integer> l2 = new ArrayList<>();  

//         inorder_p(p, l1);
//         inorder_q(q, l2);

//         if(l1.equals(l2)){
//             return true;
//         }

//         return false;
//     }

//     public void inorder_p(TreeNode p, List<Integer> l1){

//         if(p == null){
//             return;
//         }

//         inorder_p(p.left, l1);
//         l1.add(p.val);
//         inorder_p(p.right, l1);

//     }

//     public void inorder_q(TreeNode q, List<Integer> l2){

//         if(q == null){
//             return;
//         }

//         inorder_q(q.left, l2);
//         l2.add(q.val);
//         inorder_q(q.right, l2);

//     }
// }

// it do not pass 3 test cases 

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null || p.val != q.val){
            return false;
        }


        boolean left_wali_tree = isSameTree(p.left, q.left); 
        boolean right_wali_tree = isSameTree(p.right, q.right);

    return left_wali_tree && right_wali_tree; 
    }
}

//                            isSameTree(1,1)
//                           /               \
//          isSameTree(2,2)                     isSameTree(3,3)
//            /        \                          /         \
// isSameTree(null,null) isSameTree(null,null)  isSameTree(null,null) isSameTree(null,null)
//      (true)                  (true)                  (true)              (true)