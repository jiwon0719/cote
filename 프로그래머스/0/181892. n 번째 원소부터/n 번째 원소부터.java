import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = n-1; i < num_list.length; i++) {
            list.add(num_list[i]);
        }
        
        int[] num = new int[list.size()];
        int idx = 0;
        for(int l : list) {
            num[idx++] = l;
        }
        
        return num;
    }
}