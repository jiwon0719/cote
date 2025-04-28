import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0; i < names.length; i +=5) {
            list.add(names[i]);
        }
        
        String[] answer = new String[list.size()];
        int idx = 0;
        for(String str : list) {
            answer[idx++] = str;
        }
        
        return answer;
    }
}