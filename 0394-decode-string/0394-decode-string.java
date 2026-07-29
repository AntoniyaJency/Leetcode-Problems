class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        
        String curr = "";
        int num = 0;
        
        for (char ch : s.toCharArray()) {
            
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            
            else if (ch == '[') {
                numStack.push(num);
                strStack.push(curr);
                num = 0;
                curr = "";
            }
            
            else if (ch == ']') {
                int k = numStack.pop();
                String prev = strStack.pop();
                
                String temp = "";
                for (int i = 0; i < k; i++) {
                    temp += curr;
                }
                
                curr = prev + temp;
            }
            
            else {
                curr += ch;
            }
        }
        
        return curr;
    }
}