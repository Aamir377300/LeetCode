class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);

        backtrack(nums, res, new ArrayList<>(), used);
        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] used){

        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){

            if(used[i]) continue;

            // duplicate skip condition
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;

            temp.add(nums[i]);
            used[i] = true;

            backtrack(nums, res, temp, used);

            temp.remove(temp.size()-1);
            used[i] = false;
        }
    }
}