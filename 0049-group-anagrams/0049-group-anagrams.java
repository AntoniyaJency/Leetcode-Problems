class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> m=new HashMap<>();

        for(String str:strs){
            char[] ch=str.toCharArray();
            Arrays.sort(ch);

            String s=new String(ch);
            
            if(!m.containsKey(s)){
                m.put(s,new ArrayList<>());
            }
            m.get(s).add(str);
            

        }

        return new ArrayList<>(m.values());
    }
}