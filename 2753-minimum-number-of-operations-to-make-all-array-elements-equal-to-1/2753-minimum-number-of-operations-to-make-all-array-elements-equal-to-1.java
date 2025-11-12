// gcd also known as the hcf
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ones = 0;

        // Step 1: Count the number of 1s
        for (int num : nums) {
            if (num == 1) ones++;
        }

        // Step 2: If there are any 1s, result = (n - ones)
        if (ones > 0) {
            return n - ones;
        }

        // Step 3: Otherwise, find shortest subarray with gcd = 1
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break; // no need to expand further
                }
            }
        }

        // Step 4: If no subarray has gcd = 1, return -1
        if (minLen == Integer.MAX_VALUE) return -1;

        // Step 5: (minLen - 1) to make one 1, then (n - 1) to make all 1s
        return (minLen - 1) + (n - 1);
    }

    // Helper function for GCD
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}