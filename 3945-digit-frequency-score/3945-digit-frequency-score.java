class Solution {
    public int digitFrequencyScore(int n) {
        HashMap<Integer,Integer> map=new HashMap<>();

        while(n>0){
            int digit=n%10;
            map.put(digit,map.getOrDefault(digit,0)+1);
            n/=10;
        }
        int sum=0;
        for(int num:map.keySet()){
            sum+=(num*map.get(num));
        }
        return sum;
    }
}