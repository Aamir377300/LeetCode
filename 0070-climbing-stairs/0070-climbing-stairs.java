class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n; // If n=1 return 1, if n=2 return 2

        int a = 1; // Ways to reach stair 1
        int b = 2; // Ways to reach stair 2

        for (int i = 3; i <= n; i++) {
            int c = a + b; // Current = prev1 + prev2
            
            // Shift forward
            a = b; // Old 'b' becomes the new 'a'
            b = c; // New 'c' becomes the new 'b'
        }

        return b; // Return b because it holds the latest total
    }
}