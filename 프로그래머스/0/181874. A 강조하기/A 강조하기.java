class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        
        for(char ch : myString.toCharArray()) {
            if(ch == 'a') sb.append('A');
            else if(Character.isUpperCase(ch) && ch != 'A') sb.append(Character.toLowerCase(ch));
            else sb.append(ch);
        }
        
        return sb.toString();
    }
}