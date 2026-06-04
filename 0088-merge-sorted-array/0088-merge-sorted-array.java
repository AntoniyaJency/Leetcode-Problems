import java.util.*;
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        for(int i=0;i<m;i++){
            minheap.add(nums1[i]);
        }
        for(int i=0;i<n;i++){
            minheap.add(nums2[i]);
        }
        
        for(int i=0;i<n+m;i++){
            nums1[i]=minheap.poll();
        }

    }
}