import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(list.isEmpty()) list.add(arr[i]);
            else if(!list.isEmpty() && list.get(list.size() - 1) < arr[i]) list.add(arr[i]);
            else if(!list.isEmpty() && list.get(list.size() - 1) >= arr[i])  {
                list.remove(list.size() - 1);
                i--;
            }
        }
        
        int[] answer = new int[list.size()];
        int idx = 0;
        for(int l : list) {
            answer[idx++] = l;
        }
        
        return answer;
    }
}