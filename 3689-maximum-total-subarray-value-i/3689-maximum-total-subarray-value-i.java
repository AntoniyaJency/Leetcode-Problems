class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int m1=Integer.MAX_VALUE;
        int m2=Integer.MIN_VALUE;
        for(int num:nums){
            m1=Math.min(m1,num);
            m2=Math.max(m2,num);
        }
        return (long)(m2-m1)*k;
    }
}