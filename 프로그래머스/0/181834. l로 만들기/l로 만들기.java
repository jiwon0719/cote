class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        
        char l = 'l';
        int numl = l;
        for(char ch : myString.toCharArray()) {
            int num = ch;
            if(num < numl) sb.append('l');
            else sb.append(ch);
        }
        
        return sb.toString();
    }
}