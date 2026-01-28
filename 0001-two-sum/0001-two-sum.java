// brute approach

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int t; 

//         for(int i=0; i<nums.length; i++){
//             for(int j =i+1; j<nums.length; j++){
//                 if (nums[i] + nums[j] == target){
//                     return new int[]{i,j};
//                 }
//             }
//         }
//         return new int[]{};

//     }
// }


// ---------------------------------------------------------------------

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap <Integer, Integer> Hmap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int currElem = nums[i];

// 2 that is then 9-2 = 7(is present)
            int compliments = target - currElem;

            if(Hmap.containsKey(compliments)){
                return new int[]{Hmap.get(compliments), i};
            }

            Hmap.put(currElem, i);
        }
        return new int[]{};
    }
}