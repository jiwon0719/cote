import java.util.*;

class Solution {
    public int solution(String my_string, String is_prefix) {
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 1; i < my_string.length(); i++) {
            String str = "";
            for(int j = 0; j < i; j++) {
                str += my_string.charAt(j);
            }
            list.add(str);
        }
        
        return list.contains(is_prefix) ? 1 : 0;
        
    }
}