import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(n);
        
        while(n != 1) {
            if(n % 2 == 0) {
                n /= 2;
                list.add(n);
            } else {
                n = 3 * n + 1;
                list.add(n);
            }
        }
        
        int[] answer = new int[list.size()];
        int idx = 0;
        for(int i: list) {
            answer[idx++] = i;
        }
        
        return answer;
    }
}