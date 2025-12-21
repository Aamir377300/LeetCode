class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;  // Direction flag

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            // Process all nodes at current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                // Add to current level list based on direction
                if (leftToRight) {
                    level.add(node.val);  // Add normally
                } else {
                    level.add(0, node.val); // Add at beginning (reverse)
                }

                // Always enqueue children in normal order (left then right)
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(level);
            leftToRight = !leftToRight;  // Toggle direction
        }

        return result;
    }
}