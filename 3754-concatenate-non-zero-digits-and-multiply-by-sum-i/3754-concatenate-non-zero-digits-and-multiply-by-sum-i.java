class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long ans=0;
        int p=1;
        while(n>0){
            int digit=n%10;
            if(digit!=0) {
                sum+=digit;
                ans=digit*p+ans;
                p*=10;
            }
            n/=10;
        }
        return ans*sum;
    }
}