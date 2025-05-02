import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0; i < str_list.length; i++) {
            if(str_list[i].equals("l")) {
                for(int j = 0; j < i; j++) {
                    list.add(str_list[j]);
                }
                break;
            } else if(str_list[i].equals("r")) { 
                for(int j = i + 1; j < str_list.length; j++) {
                    list.add(str_list[j]);
                }
                break;
            }
        }
        
        String[] answer = new String[list.size()];
        int idx = 0;
        for(String s : list) {
            answer[idx++] = s;
        }
        
        return answer;
    }
}