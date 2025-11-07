class Solution {
    public int singleNumber(int[] nums) {
        Map <Integer, Integer> mp = new HashMap<>();
        for(int a: nums){
            mp.put(a, mp.getOrDefault(a,0)+1);
        }

        // get the values
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}