import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = l; i <= r; i++) {
            String num = "" + i;
            
            num = num.replaceAll("5", "");
            num = num.replaceAll("0", "");
            
            if(num.equals("")) list.add(i);
        }
        
        if(list.size() == 0) return new int[] {-1};
        
        int[] answer = new int[list.size()];
        int idx = 0;
        for(int num : list) {
            answer[idx++] = num;
        }
        
        return answer;
    }
}