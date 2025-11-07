// any three length can make the triangle if any two side length is greater than the third side.
// eg a,b,c ---> a+b >c, a+c > b, .......  
// but in the coding we need the a +b > c due to we do the sorting, because if we take all the other cases then it be the very long and complex {a,b,c are the just the sorted three number of the array}


// after the sorting we only check for the consecutive and also from the end due to they give us the maximum parameter.
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        for(int i=n-1; i>=2; i--){ // i>=2 thism due to we have to check for they make the triplets 
            
            int c = nums[i];
            int b = nums[i - 1];
            int a = nums[i - 2]; 
            
            if(a + b > c){
                return a+b+c;
            }
            
        }
        return 0;
    }
}