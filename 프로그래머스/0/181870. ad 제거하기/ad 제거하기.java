import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        ArrayList<String> list = new ArrayList<>();
        
        for(String str : strArr) {
            if(!str.contains("ad")) list.add(str);   
        }
        
        int idx = 0;
        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[idx++] = list.get(i);
        }
        
        return answer;
    }
}