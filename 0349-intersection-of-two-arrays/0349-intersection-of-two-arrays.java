class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list=new ArrayList<>();
        Set<Integer> set=new HashSet<>();

        for(int n:nums1) list.add(n);
        for(int m:nums2){
            if(list.contains(m)) set.add(m);
        }

        int[] ans = new int[set.size()];

        int i = 0;
        for (int n : set) {
            ans[i] = n;
            i++;
        }

        return ans;


    }
}