import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // Step 1: Map to store next greater for each element
        Map<Integer, Integer> map = new HashMap<>();

        // Step 2: Stack to process nums2
        Stack<Integer> stack = new Stack<>();

        // Step 3: Traverse nums2
        for (int num : nums2) {

            // While stack is not empty and current number is greater
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }

            // Push current number
            stack.push(num);
        }

        // Step 4: Remaining elements have no next greater
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Step 5: Build answer for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}
