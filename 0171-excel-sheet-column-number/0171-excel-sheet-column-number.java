class Solution {
    public int titleToNumber(String columnTitle) {
        int result=0;
        int power=1;
        for(int i=columnTitle.length()-1;i>=0;i--){
            char c=columnTitle.charAt(i);
            int val=c-'A'+1;

            result+=power*val;
            power*=26;

        }
        return result;
        
    }
}