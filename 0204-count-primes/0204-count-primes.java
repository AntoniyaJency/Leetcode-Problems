class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        boolean[] p=new boolean[n];
        for(int i=2;i<n;i++) p[i]=true;
        for(int i=2;i*i<n;i++){
            if(p[i]==true){
                for(int j=i*i;j<n;j+=i) p[j]=false;
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(p[i]==true) count++;
        }

        return count;
    }
}