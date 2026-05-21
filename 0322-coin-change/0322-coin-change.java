import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // Create a DP table of size amount + 1
        int[] dp = new int[amount + 1];
        
        // Fill the array with a value larger than any possible answer (amount + 1)
        // We use amount + 1 as "infinity" because you can't have more coins than the amount itself
        Arrays.fill(dp, amount + 1);
        
        // Base case: 0 coins are needed to make amount 0
        dp[0] = 0;
        
        // Build the table from 1 up to 'amount'
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // If the coin is smaller than the current amount 'i'
                if (i >= coin) {
                    // Take the minimum: current stored value vs (1 + ways to make remainder)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        
        // If dp[amount] is still the initial "infinity", return -1
        return dp[amount] > amount ? -1 : dp[amount];
    }
}