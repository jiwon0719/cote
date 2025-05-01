import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 2) list.add(i);
        }
        
        if(list.size() == 0) return new int[] {-1};
        
        int s = list.get(0);
        int e = list.get(list.size() - 1);
        
        int[] answer = new int[e - s + 1];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = arr[s++];
        }
        
        return answer;
    }
}