class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }
    public void backtrack(int start, int[] nums, List<Integer> temp, List<List<Integer>> res){
        // there is no need of the base condition kuki for loop me condition wala parameter i ko kabhi nums ke length se jaada jane dega nahi so proper control rahega
        res.add(new ArrayList<>(temp));



        for(int i = start; i<nums.length; i++){

            if(i > start && nums[i] == nums[i-1]) continue; // due to continue if the condition come then the particular iteration is not run

            temp.add(nums[i]);
            backtrack(i+1, nums, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}