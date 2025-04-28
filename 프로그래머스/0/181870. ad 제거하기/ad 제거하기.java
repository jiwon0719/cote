class Solution {
    public String[] solution(String[] strArr) {
        int size = 0;
        for(String str : strArr) {
            if(!str.contains("ad")) size++;
        }
        
        String[] answer = new String[size];
        int idx = 0;
        for(String str : strArr) {
            if(!str.contains("ad")) answer[idx++] = str;
        }
        
        
        return answer;
    }
}