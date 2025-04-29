import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0; i < my_string.length(); i++) {
            String suffix = my_string.substring(i);
            list.add(suffix);
        }
        
        Collections.sort(list);
        
        String[] answer = new String[list.size()];
        int idx = 0;
        for(String str : list) {
            answer[idx++] = str;
        }
        
        return answer;
        
    }
}