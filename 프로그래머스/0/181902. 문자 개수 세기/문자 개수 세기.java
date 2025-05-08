class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        for(int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            int ascii = ch;
            if(ascii < 97) { // 대문자
                answer[ascii - 65]++;
            } else { // 소문자
                answer[ascii - 97 + 26]++;
            }
        }
        
        return answer;
    }
}