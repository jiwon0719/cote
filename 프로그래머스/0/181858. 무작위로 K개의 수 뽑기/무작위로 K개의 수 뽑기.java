import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        // Set써서 동일한 원소 있는지 확인
        // 있으면 continue, 없으면 추가(list)
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for(int a : arr) {
            int presize = set.size();
            set.add(a);
            if(presize != set.size()) { // 새로운 원소라면
                list.add(a);
            }
        }
        
        // list 길이가 k 이상이면 배열로 그냥 만들기
        // list 길이가 k 미만이면 고정길이로 만들고 -1로 채우기, 복사
        if(list.size() >= k) {
            int[] answer = new int[k];
            for(int i = 0; i < k; i++) {
                answer[i] = list.get(i);
            }
            return answer;
        } else {
            int[] answer = new int[k];
            Arrays.fill(answer, -1);
            int idx = 0;
            for(int l : list) {
                answer[idx++] = l;
            }
            return answer;
        }
    }
}