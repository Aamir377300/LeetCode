class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) sum += b;

        long left = 0, right = sum / n;  // max possible time
        long ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canRun(mid, n, batteries)) {
                ans = mid;       // feasible, try longer
                left = mid + 1;
            } else {
                right = mid - 1; // infeasible, try shorter
            }
        }
        return ans;
    }

    private boolean canRun(long time, int n, int[] batteries) {
        long total = 0;
        for (int b : batteries) {
            total += Math.min(b, time);
        }
        return total >= (long) n * time;
    }
}