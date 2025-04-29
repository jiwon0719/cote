import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> deleteList = new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int num : delete_list) {
            deleteList.add(num);
        }
        
        for(int num : arr) {
            if(!deleteList.contains(num)) {
                list.add(num);
            }
        }
        
        int[] answer = new int[list.size()];
        int idx = 0;
        for(int num : list) {
            answer[idx++] = num;
        }

        return answer;
    }
}