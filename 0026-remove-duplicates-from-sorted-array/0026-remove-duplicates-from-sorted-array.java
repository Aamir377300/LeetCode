// did not get the concept correctly

class Solution {
    public int removeDuplicates(int[] nums) {
        int nextNonDupe = 1; // index where next unique element will go
        for (int i = 1; i < nums.length; i++) {
            if (nums[nextNonDupe - 1] != nums[i]) {
                nums[nextNonDupe] = nums[i];
                nextNonDupe++;
            }
        }

        return nextNonDupe;
    }
}