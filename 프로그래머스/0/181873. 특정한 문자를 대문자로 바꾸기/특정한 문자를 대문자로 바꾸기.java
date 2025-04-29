class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder sb = new StringBuilder();
        
        for(char ch : my_string.toCharArray()) {
            if(String.valueOf(ch).equals(alp)) sb.append(Character.toUpperCase(ch));
            else sb.append(ch);
        }
        
        return sb.toString();
    }
}