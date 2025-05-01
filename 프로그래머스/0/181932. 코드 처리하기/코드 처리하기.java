class Solution {
    public String solution(String code) {
        int mode = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);
            
            if(mode == 0) {
                if(ch != '1' && i % 2 == 0) sb.append(ch);
                else if(ch == '1') mode = 1;
            } else { 
                if(ch != '1' && i % 2 != 0) sb.append(ch);
                else if(ch == '1') mode = 0;
            }
        }
        
        if(sb.toString().length() == 0) return "EMPTY";
        return sb.toString();
    }
}