import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        // 2의 거듭제곱이 되는 숫자 찾기
        int n = arr.length;
        int targetLength = 1;
        while(targetLength < n) {
            targetLength *= 2;
        }
        
        int[] answer = new int[targetLength];
        
        Arrays.fill(answer, 0); // 0으로 채우기
        
        for(int i = 0; i < n; i++) {
            answer[i] = arr[i];
        }
        
        return answer;
    }
}