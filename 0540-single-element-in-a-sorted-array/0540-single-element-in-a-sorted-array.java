// class Solution {
//     public int singleNonDuplicate(int[] nums) {
//         int a=0;
//         Map <Integer, Integer> mp =new HashMap<>();

//         // for(int i=0; i<nums.length; i++){
//         //     mp.put(i, mp.getOrDefault(i,0)+1);
//         // }

//         // ---or ---

//         for(int i: nums){
//             mp.put(i, mp.getOrDefault(i,0)+1);
//         }

//         for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
//             if (entry.getValue() == 1) {
//                 a = entry.getKey();
//             }
//         }

//         return a;
//     }
// }

// using binary search : O(log n) time and O(1) space.

// theory: agar mid find karn ke baad ys se [mid-1] or [mid+1] se match karna chaiye, if it do not match then it is the answer, agar [mid-1] se match huwa to then it is present in the left of the mid, kyki wahi odd no of element remain after the pair of the mid{if do not get it dry run}, same for the [mid+1] 


class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Ensure mid is even
            if (mid % 2 == 1) mid--;

            // Check if pair is perfect
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2; // go right
            } else {
                right = mid; // go left
            }
        }

        return nums[left];
    }
}