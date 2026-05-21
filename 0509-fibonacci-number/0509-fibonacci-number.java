// Recursive Approach

// class Solution {
//     public int fib(int n) {
//         // Base Cases
//         if (n == 0) {
//             return 0;
//         }
//         if (n == 1) {
//             return 1;
//         }
        
//         // Recursive Step: F(n) = F(n-1) + F(n-2)
//         return fib(n - 1) + fib(n - 2);
//     }
// }

// DP Approach
class Solution {
    public int fib(int n) {

        if(n <=1) return n; // simple of the base condition sees above

        int[] dp = new int[n+1];

        dp[0] =0;
        dp[1] = 1;

        // build
        for(int i =2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];

    }
}