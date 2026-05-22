class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) sum += n;

        // If target is unreachable
        if (Math.abs(target) > sum || (sum + target) % 2 != 0) return 0;
        
        int subsetSum = (sum + target) / 2;
        int n = nums.length;
        
        // dp[i][j] = number of ways to get sum j using first i elements
        int[][] dp = new int[n + 1][subsetSum + 1];
        
        // Base case: There is 1 way to get sum 0 (by choosing an empty subset)
        dp[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= subsetSum; j++) {
                // If we don't include nums[i-1]
                dp[i][j] = dp[i-1][j];
                
                // If we include nums[i-1]
                if (j >= nums[i-1]) {
                    dp[i][j] += dp[i-1][j - nums[i-1]];
                }
            }
        }
        
        return dp[n][subsetSum];
    }
}