// try to solve for time: o(n) and space: o(1) :-> question is asking in this

import java.util.*;

// using hashmap  : time o(n) with the space : o(n)
// class Solution {
//     public List<Integer> findDuplicates(int[] nums) {
//         List <Integer> lt = new ArrayList<>();
//         HashMap <Integer, Integer> mp = new HashMap<>();

// // hp.getOrDefault(num, 0) +1 :-> this is count the frequency like if the 3 is appear twice then instead of provide key value, it increase key 3 to its value 2
//         for(int num : nums){
//             mp.put(num , mp.getOrDefault(num, 0) +1);
//         }

//         for(int key : mp.keySet()){
//             if(mp.get(key) ==2){
//                 lt.add(key);
//             }
//         }

//         return lt;
//     }
// }

// using hashSet : time o(n) with the space : o(n)

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List <Integer> lt = new ArrayList<>();
        Set <Integer> set = new HashSet<>();

        // set is do not allow duplicate if they are unable to add then add in the list

        for(int num: nums){
            if(set.contains(num)){
                lt.add(num);
            }
            else{
                set.add(num);
            }
        }

        return lt;
    }
}