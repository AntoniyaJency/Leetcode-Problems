class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        List<Character> list=new ArrayList<>();
        for(char c:magazine.toCharArray()) list.add(c);
        int ptr=0;
        while(ptr<ransomNote.length() && list.contains(ransomNote.charAt(ptr)) 
                && !list.isEmpty()){
            list.remove(Character.valueOf(ransomNote.charAt(ptr)));
            ptr++;
        }
        if(ptr==ransomNote.length()) return true;
        return false;
    }
}