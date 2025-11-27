class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        
        // Build prefix sums
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        // Track minimum prefix sum for each mod class
        long[] minPrefix = new long[k];
        for (int i = 0; i < k; i++) {
            minPrefix[i] = Long.MAX_VALUE;
        }
        
        long ans = Long.MIN_VALUE;
        
        for (int i = 0; i <= n; i++) {
            int mod = i % k;
            
            // If we have seen a prefix with same mod, try candidate
            if (minPrefix[mod] != Long.MAX_VALUE) {
                ans = Math.max(ans, prefix[i] - minPrefix[mod]);
            }
            
            // Update minPrefix for this mod class
            minPrefix[mod] = Math.min(minPrefix[mod], prefix[i]);
        }
        
        return ans;
    }
}