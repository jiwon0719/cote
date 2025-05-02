class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        // 슬라이딩 윈도우 알고리즘
        // String에도 적용되겠지? 
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < pat.length(); i++) {
            sb.append(myString.charAt(i));
        }
        
        if(sb.toString().equals(pat)) answer++;
        
        for(int i = pat.length(); i < myString.length(); i++) {
            sb.append(myString.charAt(i));
            sb.deleteCharAt(0);
            
            if(sb.toString().equals(pat)) answer++;
        }
        
        return answer;
    }
}