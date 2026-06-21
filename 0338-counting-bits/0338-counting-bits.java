class Solution {
    public int[] countBits(int n) {
        int count=0;
        int[] val=new int[n+1];
        for(int i=1;i<=n;i++){
            count=0;
            int j=i;
            while(j!=0){
                if((j&1)==1) count++;
                j=j>>>1;

            }
            val[i]=count;
        }
        return val;
    }
}