class Solution {
    public int[] scoreValidator(String[] events) {
        int score=0;
        int counter=0;
        for(int i=0;i<events.length;i++){
            if(counter==10) break;
            if(events[i].equals("0")||events[i].equals("1")||events[i].equals("2")||
            events[i].equals("3")||events[i].equals("4")||events[i].equals("5")||events[i].equals("6")){
                score+=Integer.valueOf(events[i]);
            }
            else if(events[i].equals("W")) counter++;
            else if(events[i].equals("WD")) score++;
            else score++;
        }

        
        int[] total={score,counter};
        return total;

    }
}