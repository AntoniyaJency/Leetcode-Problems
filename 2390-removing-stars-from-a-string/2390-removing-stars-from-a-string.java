class Solution {
    public String removeStars(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!stack.isEmpty() && c=='*') stack.pop();
            else stack.push(c);
        }
        StringBuilder result = new StringBuilder();
        for (char ch : stack) 
            result.append(ch);
        return result.toString();
    }
}