import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = intervals[0][0]; i <= intervals[0][1]; i++) {
            list.add(arr[i]);
        }
        for(int i = intervals[1][0]; i <= intervals[1][1]; i++) {
            list.add(arr[i]);
        }
        
        int[] answer = new int[list.size()];
        int idx = 0;
        for(int l : list) {
            answer[idx++] = l;
        }
        
        return answer;
    }
}