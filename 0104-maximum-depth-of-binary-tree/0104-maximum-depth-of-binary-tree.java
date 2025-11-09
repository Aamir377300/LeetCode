class Solution {
    public int maxDepth(TreeNode root) {

        /*
        VISUALIZATION OF RECURSION
        ---------------------------

        Given Tree (root = [3,9,20,null,null,15,7]):

                3
               / \
              9   20
                 /  \
                15   7

        CALL STACK (going DOWN)
        maxDepth(3)
            maxDepth(9) -> \U0001f9e0 main left of the maxDepth(3)
                maxDepth(null) -> 0(left)
                maxDepth(null) -> 0(right)
            return max(0,0) + 1 = 1   (depth of node 9)

            maxDepth(20) -> \U0001f9e0 main right of the maxDepth(3)
                maxDepth(15)
                    maxDepth(null) -> 0(left)
                    maxDepth(null) -> 0(right)
                return max(0,0) + 1 = 1   (depth of node 15)

                maxDepth(7)
                    maxDepth(null) -> 0(left)
                    maxDepth(null) -> 0(right)
                return max(0,0) + 1 = 1   (depth of node 7)

            return max(1,1) + 1 = 2   (depth of node 20)

        // the left of the 3(root) is the 1 (depth)
        // the right of the 3(root) is the 2 (depth)

        //  Math.max(leftHt, rightHt) + 1; --> give us the 3


        Final Output = 3
        */

        if (root == null) {
            return 0;
        }

        int leftHt = maxDepth(root.left);
        int rightHt = maxDepth(root.right);

        return Math.max(leftHt, rightHt) + 1;
    }
}