// O(log n) ask so we must have use the binary search sorting algorithm


// there can be multiple duplicate but you only have to return first and last occurace from the duplicates like [1.2.2,3.2] => [1.4]

// the first occurance must be in the left side of the mid 
// the last occurance must be in the right side of the mid

// we make two for finding the occurance's

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[] {first, last};
    }

    public int findFirst(int[] nums, int target){
        int left =0;
        int right = nums.length-1;
        int first_value = -1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                first_value = mid;
                // we have find the first occurance, so there is chance they can be present at the leftest to the middle 
                right = mid -1;
            }
            else if(nums[mid]< target){
                left = mid +1;
            }
            else{
                right = mid - 1;
            }

        }

        return first_value;
    }

    public int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int last_value = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                last_value = mid;   
                // we have find the last occurance, so there is chance they can be present at the rightest to the middle      
                left = mid + 1;    
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return last_value;
    }
}