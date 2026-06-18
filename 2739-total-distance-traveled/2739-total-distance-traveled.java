class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        //int sum=mainTank*10;
       // maintank
       int sum=0;
        int i=0;
        while(mainTank>0){
            if(mainTank<5){
                sum+=(mainTank*10);
                mainTank=0;
            }
            else{
                sum+=50;
                mainTank-=5;
                if(additionalTank>0){
                    mainTank++;
                    additionalTank-=1;
                }
                
            }
            
        }

        return sum;
    }
}