// it is the kdane's Algo

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];


        for(int i=1; i< nums.length; i++){ // start from the 1 not 0 due to i 0 is already we have used and if nums.length == 0 then it gives thes the amswer
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);

        }
        return maxSum;
    }
}