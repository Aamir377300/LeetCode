// // https://drive.google.com/file/d/1R6_wZYaZkGNVRaI1y64ZHCNo_wXW6DaA/view?usp=sharing

// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         dfs(root, 0, result);
//         return result;
//     }

//     public void dfs(TreeNode node, int level, List<Integer> result) {
//         if (node == null) return;

//         // If visiting this level for the first time → add the node
//         if (level == result.size()) {
//             result.add(node.val);
//         }

//         // FIRST go right, then left
//         dfs(node.right, level + 1, result);
//         dfs(node.left, level + 1, result);
//     }
// }


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Add the first node (rightmost) of current level
            TreeNode node = queue.peek();
            result.add(node.val);
            
            // Process all nodes at current level
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                
                // Add right child first, then left
                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);
            }
        }
        
        return result;
    }
}