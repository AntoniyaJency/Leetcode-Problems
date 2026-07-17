import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a1 = nums1.length;
        int a2 = nums2.length;
        int a3 = a1 + a2;
        
       
        int[] nums3 = new int[a3];
        System.arraycopy(nums1, 0, nums3, 0, a1);
        System.arraycopy(nums2, 0, nums3, a1, a2);
        
      
        Arrays.sort(nums3);
        
        
        if (a3 % 2 == 1) {
           
            return nums3[a3 / 2];
        } else {
           
            return (nums3[a3 / 2 - 1] + nums3[a3 / 2]) / 2.0;
        }
    }
}
