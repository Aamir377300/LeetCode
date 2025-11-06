// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int first = -1, last = -1;

//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == target) {
//                 if (first == -1) first = i; // first occurrence
//                 last = i; // keeps updating till last occurrence
//             }
//         }

//         return new int[]{first, last };
//     }
// }

// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int arr[] = {-1, -1};
//         int i=0;

//         int left=0; 
//         int right = nums.length-1;


//         while(left<= right){
//             int mid = left + (right - left)/2;

//             if(nums[mid] == target){
//                 arr[i] = mid;
//                 i++;
//             }
//             if(nums[mid] <target){
//                 left = mid +1;
//             }
//             if(nums[mid]>target){
//                 right = mid -1;
//             }

//         }

//         return arr;
//     }
// }


// the above is wrong due to the one binary serarch is give us one finding element, so for this we have to create two binary search

class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{firstPos(nums, target), lastPos(nums, target)};
    }

    public int firstPos(int[] nums, int target) {
        int left = 0, right = nums.length - 1, first = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                first = mid;
                // ask gpt why we do this 
                right = mid - 1; // keep searching left
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return first;
    }

    public int lastPos(int[] nums, int target) {
        int left = 0, right = nums.length - 1, last = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                last = mid;
                // ask gpt why we do this 
                left = mid + 1; // keep searching right
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return last;
    }
}