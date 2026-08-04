class Solution {

    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);

        List<Integer> ans = new ArrayList<>();

        for (int i = nums[0]; i <=nums[nums.length-1]; i++) 
            ans.add(i);
        for (int i = 0; i < nums.length; i++) 
             if(ans.contains(nums[i])) ans.remove(Integer.valueOf(nums[i]));
        return ans;
    }
}