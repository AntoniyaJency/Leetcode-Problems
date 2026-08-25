class Solution {
    public int missingMultiple(int[] nums, int k) {
        List<Integer> list=new ArrayList<>();
        for(int num:nums) list.add(num);
        int i=1;
        while(true){
            if(!list.contains(k*i)) return k*i;
            i++;
        }
       
    }
}