class Solution {
    public int trailingZeroes(int n) {
        if(n<4) return 0;
        int count=0;
        while(n>1){
            n/=5;
            count+=n;
        }
        return count;
    }
}