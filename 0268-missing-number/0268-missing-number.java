// Approach: We add the the n = n, n-1, n-2; then add the nums(in last subtract)
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length; 
        
        int expected_Sum = n * (n + 1) / 2; // this sum 0 to n

        // Sum of elements in the array
        int actualSum = 0;
        for(int a: nums){
            actualSum = actualSum + a;
        }

        // Missing number is the difference
        return expected_Sum - actualSum;
    }
}