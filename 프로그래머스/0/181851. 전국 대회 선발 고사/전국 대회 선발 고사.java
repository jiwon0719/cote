import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int i = 0; i < attendance.length; i++) {
            if(attendance[i]) list.add(new int[] {i, rank[i]}); // 학생번호, 등수
        }
        
        Collections.sort(list, (a, b) -> a[1] - b[1]); // 등수를 기준으로 오름차순

        int a = list.get(0)[0];
        int b = list.get(1)[0];
        int c = list.get(2)[0];
        
        return (10000 * a) + (100 * b) + c;
    }
}