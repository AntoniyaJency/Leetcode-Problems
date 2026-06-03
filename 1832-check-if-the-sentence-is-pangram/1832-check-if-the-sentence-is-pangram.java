class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set=new HashSet<>();
        for(int i=0;i<sentence.length();i++){
            char j=sentence.charAt(i);
            set.add(j);
        }
        if(set.size()!=26) return false;
        return true;
    }
}