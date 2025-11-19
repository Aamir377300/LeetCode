// Approach:- Each stick has a different height. Now you want to choose two sticks that can hold the most water between them.{The two sticks act like the left and right walls}

// Water = distance × smaller height 
// {Water can ONLY fill up to the height of the shorter stick. Because water will spill from the shorter side. So the smaller stick controls the height of the water}

class Solution {
    public int maxArea(int[] height) {

        // Pointer at the leftmost stick
        int left = 0;

        // Pointer at the rightmost stick
        int right = height.length - 1;

        // This will store the maximum water area found so far
        int maxArea = 0;

        // Continue until the two pointers meet
        while (left < right) {

            // Width of the container → distance between the two sticks
            int width = right - left;

            // The water height is decided by the smaller stick
            int waterHeight = Math.min(height[left], height[right]);

            // Area = width × smaller height
            int currentArea = width * waterHeight;

            // Update maxArea if we found a bigger area
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer that has the smaller height
            // because a smaller height LIMITS the water level.
            // Moving bigger height is useless → it cannot increase area.
            if (height[left] < height[right]) {
                left++;    // move left pointer to try a taller stick
            } else {
                right--;   // move right pointer to try a taller stick
            }
        }

        // Final maximum water area
        return maxArea;
    }
}