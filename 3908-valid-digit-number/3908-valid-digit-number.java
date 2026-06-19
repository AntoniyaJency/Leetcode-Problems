class Solution {
    public boolean validDigit(int n, int x) {
        /*int temp=n;
        int rev=0;
        int digit=temp%10;
            rev=digit+rev*10;
            temp/=10;*/
            boolean count=false;
            int firstdigit=0;
        while(n>=10){
            
            if(n%10==x) count=true;
            firstdigit=n/10;
            n/=10;
        }

        if(count && x!=firstdigit) return true;
        return false;
    }
}