class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int lastIndex = -1; // Track the index of the last seen 1

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastIndex != -1 && i - lastIndex <= k) {
                    return false; // Not enough distance between 1s
                }
                lastIndex = i; // Update last seen 1
            }
        }

        return true; // All 1s are at least k apart
    }
}