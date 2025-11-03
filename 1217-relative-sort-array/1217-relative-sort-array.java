// first we make a hashmap in which we store the arr1 with their frequency, then we using a secound for loop we get the the frequency and using arr2, write that time of arr2 so the order is preseverved as per arr2

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer, Integer> mp = new HashMap<>();
        int result[] = new int[arr1.length];

        for(int a: arr1){ 
            mp.put(a, mp.getOrDefault(a,0)+1);
        } // {2=3, 3=2, 1=1, 4=1, 6=1, 7=1, 9=1, 19=1}

        int index =0;
        for(int a : arr2){ // [2,1,4,3,9,6]
            int noOfFreq = mp.get(a); // 3

            for(int i=0; i<noOfFreq; i++){
                result[index++] = a;
            }
            mp.remove(a); // we remove so in last we see which two are not in the arr2

        }

        // handle remaining which is not present in arr2

        List<Integer> remaining = new ArrayList<>(mp.keySet());
        Collections.sort(remaining);
        
        for(int num : remaining) {
            int count = mp.get(num);
            for(int i = 0; i < count; i++) {
                result[index++] = num;
            }
        }
        
        return result;

    }
}