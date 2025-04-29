class Solution {
    public String solution(String n_str) {    
        int start = 0;
        for(int i = 0; i < n_str.length(); i++) {
            char ch = n_str.charAt(i);
            
            if(ch != '0') {
                start = i;
                break;
            }
        }
        
        return n_str.substring(start, n_str.length());
    }
}