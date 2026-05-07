class Solution {
    public boolean canJump(int[] nums) {

        int maxReach = 0;

        for(int i = 0; i < nums.length; i++) {

            // if current index is not reachable
            if(i > maxReach) return false;

            // update farthest reachable position
            maxReach = Math.max(maxReach, i + nums[i]);

            // if we already reached end
            if(maxReach >= nums.length - 1) return true;
        }

        return true;
    }
}