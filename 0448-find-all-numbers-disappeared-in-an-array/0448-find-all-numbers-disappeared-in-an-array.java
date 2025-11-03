// n represent the no of the integer in the nums

import java.util.*;
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List <Integer> lt = new ArrayList<>();
        
        // We use the Hashset due to if it remove the duplicate, then we do not have to care about the duplocate, we just wanna to know from [1,n] is there is element is present

        Set <Integer> st = new HashSet<>();

        for(int a: nums){
            st.add(a);
        }
       

        for(int i=1; i<=nums.length; i++){
            if(!st.contains(i)){
                lt.add(i);
            }
        }

        return lt;
    }
}