import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0; i < todo_list.length; i++) {
            if(!finished[i]) list.add(todo_list[i]);
        }
        
        String[] answer = new String[list.size()];
        int idx = 0;
        for(String str : list) {
            answer[idx++] = str;
        }
        
        return answer;
    }
}