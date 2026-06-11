class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int digit =0;
        int rev=0;
        int temp =x;
        
        while(x!=0){
            digit=x%10;
            x/=10;
            rev=rev*10+digit;
        }
        if(temp==rev) return true;
        return false;
    }
}