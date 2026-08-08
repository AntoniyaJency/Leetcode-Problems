class Solution {
    public String predictPartyVictory(String senate) {
        PriorityQueue<Integer> rq=new PriorityQueue<>();
        PriorityQueue<Integer> dq=new PriorityQueue<>();

        int n=senate.length();

        for(int i=0;i<n;i++){
            char c=senate.charAt(i);
            if(c=='R') rq.add(i);
            else dq.add(i);
        }

        while(!rq.isEmpty() && !dq.isEmpty()){
            int r=rq.poll();
            int d=dq.poll();

            if(r<d) rq.add(r+n);
            else dq.add(d+n);
        }

        return rq.isEmpty()? "Dire":"Radiant";
    }
}