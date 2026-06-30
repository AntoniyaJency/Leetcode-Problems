class Solution {
    public int minCostClimbingStairs(int[] cost) {

        /*for(int num:cost){
            int curr=Math.max(prev1,prev2+num);
            prev2=prev1;
            prev2=curr;
        }

        return prev1;*/

        /*int count=0;
        int next1=0;
        int next2=0;
        for(int i=0;i<cost.length;i++){
            int current=Math.min(next1,next2+cost[i]);
            count+=current;
            next2=next1;
            next1=current;
        }

        return count;*/

        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        return Math.min(cost[cost.length-1], cost[cost.length-2]);


        
        

    }
}