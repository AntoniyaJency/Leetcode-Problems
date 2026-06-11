class Solution {
    public int numberOfMatches(int n) {
        int sum=0;
        while(n>0){
            if(n%2==0){
                n=n/2;
                sum+=n;
            }
            else{
                if(n==1) break;
                n=(n-1)/2;
                sum+=n;
                n+=1;
            }
        }
        return sum;
    }
}