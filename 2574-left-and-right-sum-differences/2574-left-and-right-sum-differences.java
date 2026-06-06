class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int leftsum=0;
            if(i==0) leftsum=0;
            else{
                for(int j=i-1;j>=0;j--){
                    leftsum+=nums[j];
                }
            }
            int rightsum=0;
            if(i==nums.length-1) rightsum=0;
            else{
                for(int k=i+1;k<nums.length;k++){
                    rightsum+=nums[k];
                }
            }
            res[i]=Math.abs(leftsum-rightsum);
        }
        return res;
    }
}