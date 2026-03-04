// https://drive.google.com/file/d/1E7W6zQ69q0IqZz0le4Xdo7EQsXboaezb/view?usp=sharing
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }
    public void backtrack(int start, int[] nums, List<Integer> temp, List<List<Integer>> res){
        // there is no need of the base condition kuki for loop me condition wala parameter i ko kabhi nums ke length se jaada jane dega nahi so proper control rahega
        res.add(new ArrayList<>(temp));

        for(int i = start; i<nums.length; i++){
            temp.add(nums[i]);
            backtrack(i+1, nums, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}