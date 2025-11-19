// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         int i=0; int j=0;
//         int sum=0; int count=0;

//         while(i<nums.length && j<nums.length){
//             sum = sum + nums[i];
//             i++;

//             if(sum==goal){
//                 count++; 

//             }

//             while(sum>goal){
//                 sum = sum - nums[j];
//                 j++;
//             }
//             while(sum==goal){
//                 count++;
//                 sum-= nums[j];
//                 j++;
//             }
//         }
//     }
// }

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == goal) {
                    count++;
                }
            }
        }
        return count;
    }
}
