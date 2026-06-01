import java.util.*;
class Solution {
    public int minimumCost(int[] cost) {
       Arrays.sort(cost);
       int l=cost.length;
       int sum=0;
       int count=0;
       for(int i=l-1;i>=0;i--){
        count++;
        if(count%3==0) continue;
        sum+=cost[i];

       }
       return sum; 
    }
}