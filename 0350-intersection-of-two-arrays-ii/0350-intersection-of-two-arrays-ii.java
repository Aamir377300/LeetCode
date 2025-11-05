// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {

//         int arr[]; // Wrong here we have to provide the length of the array so we have to use the arrayList due to its dynamic nature beacsue we do not have to provide its length


//         for(int i=0; i<nums1.length; i++){
//             for(int j=0; j<nums2.length; j++){
//                 if(nums1[i]==nums2[j]){
//                     return arr[];
//                 }
//             }
//         }
//     }
// }

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            list1.add(nums1[i]);
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
            if(list1.contains(nums2[i])){
                list2.add(nums2[i]);
                list1.remove(Integer.valueOf(nums2[i])); // it helps in handling duplicates and current frequency
            }
        }
        int[] res = new int[list2.size()];
        for(int i=0;i<list2.size();i++){
            res[i]=list2.get(i);
        }
        return res;
    }
}
