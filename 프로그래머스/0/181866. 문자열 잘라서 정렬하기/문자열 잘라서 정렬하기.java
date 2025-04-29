import java.util.*;

class Solution {
    public String[] solution(String myString) {        
        String[] splitArr = myString.split("x");
    
        ArrayList<String> list = new ArrayList<>();
        for(String str : splitArr) {
            if(!str.isEmpty()) list.add(str);
        }
        
        String[] answer = new String[list.size()];
        int idx = 0;
        for(String str : list) {
            answer[idx++] = str;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}