import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(String str : intStrs) {
            int i = Integer.parseInt(str.substring(s, s + l));
            if(i > k) list.add(i);
        }
        
        int[] answer = new int[list.size()];
        int idx = 0;
        for(int i : list) {
            answer[idx++] = i;
        }
        
        return answer;
    }
}