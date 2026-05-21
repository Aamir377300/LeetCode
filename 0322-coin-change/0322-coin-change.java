class Solution {
    public int coinChange(int[] coins, int amount) {
        // Base case: if amount is 0, we need 0 coins
        if (amount == 0) return 0;
        // Base case: if amount is negative, this path is invalid
        if (amount < 0) return -1;

        int minCoins = Integer.MAX_VALUE;

        // Try every coin
        for (int coin : coins) {
            int result = coinChange(coins, amount - coin);
            
            // If result is valid (not -1) and smaller than current min
            if (result >= 0 && result < minCoins) {
                minCoins = result + 1;
            }
        }

        // If minCoins is still MAX_VALUE, no combination was found
        return (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
    }
}