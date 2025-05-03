import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        
        for(char ch : myStr.toCharArray()) {
            if(ch == 'a' ||  ch == 'b' || ch == 'c') {
                if(sb.length() > 0) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(ch);
            }
        }
        
        // 마지막 남아있는 sb 추가
        if (sb.length() > 0) {
            list.add(sb.toString());
        }
        
        if (list.isEmpty()) {
            return new String[]{"EMPTY"};
        }
        
        return list.toArray(new String[0]);
        
    }
}