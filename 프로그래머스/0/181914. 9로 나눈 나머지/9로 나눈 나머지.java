class Solution {
    public int solution(String number) {
        int answer = 0;
        
        for(char ch : number.toCharArray()) {
            answer += Character.getNumericValue(ch);
        }
        
        return answer % 9;
    }
}