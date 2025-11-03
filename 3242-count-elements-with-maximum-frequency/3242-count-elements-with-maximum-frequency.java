class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int a: nums){
            map.put(a, map.getOrDefault(a, 0)+1);
            // {1=2, 2=2, 3=1, 4=1}
        }

        int maxFreq = 0;

        for(int value : map.values()){
            maxFreq = Math.max(maxFreq, value);
        }

        // Count total elements having this max frequency
        int count = 0;

        for(int value: map.values()){
            if(value == maxFreq){
                count = count + value;
            }
        }

        return count;

    }
}