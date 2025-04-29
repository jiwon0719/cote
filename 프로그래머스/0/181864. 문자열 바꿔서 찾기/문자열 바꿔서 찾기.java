class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        for(char ch : myString.toCharArray()) {
            if(ch == 'A') sb.append('B');
            else if(ch == 'B') sb.append('A');
            else sb.append(ch);
        }
        
        return sb.toString().contains(pat) ? 1 : 0;
    }
}