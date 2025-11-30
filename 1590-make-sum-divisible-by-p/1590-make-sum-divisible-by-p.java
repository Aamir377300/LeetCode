import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        int target = (int)(total % p);
        if (target == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // base case

        long prefix = 0;
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int curr = (int)(prefix % p);

            // we want (curr - target) % p seen before
            int need = (curr - target + p) % p;
            if (map.containsKey(need)) {
                res = Math.min(res, i - map.get(need));
            }

            // update map with latest index
            map.put(curr, i);
        }

        return res == nums.length ? -1 : res;
    }
} 