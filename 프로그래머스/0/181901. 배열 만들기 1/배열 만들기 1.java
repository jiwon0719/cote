import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) {
            if(i % k == 0) list.add(i);
        }
        
        int[] answer = new int[list.size()];
        int idx = 0;
        for(int l : list) {
            answer[idx++] = l;
        }
        
        return answer;
    }
}