class Solution {
    public int tribonacci(int n) {
        if(n==1||n==0) return n;
        if(n==2) return 1;
        int prev3=0;
        int prev2=1;
        int prev1=1;
        int curr=2;

        for(int i=3;i<=n;i++){
            curr=prev3+prev1+prev2;
            prev3=prev2;
            prev2=prev1;
            prev1=curr;
        }

        return curr;
    }
}