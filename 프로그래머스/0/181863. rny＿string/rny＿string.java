class Solution {
    public String solution(String rny_string) {
        
        StringBuilder sb = new StringBuilder();
        for(char ch : rny_string.toCharArray()) {
            if(ch == 'm') sb.append("rn");
            else sb.append(ch);
        }
        
        return sb.toString();
        
    }
}