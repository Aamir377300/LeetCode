class Solution {
    public int numSub(String s) {
        final int MOD = 1_000_000_007;
        long count = 0;
        long consecutiveOnes = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                consecutiveOnes++;
                count = (count + consecutiveOnes) % MOD;
            } else {
                consecutiveOnes = 0;
            }
        }

        return (int) count;
    }
}