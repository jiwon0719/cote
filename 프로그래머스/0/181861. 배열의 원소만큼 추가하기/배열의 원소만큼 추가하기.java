class Solution {
    public int[] solution(int[] arr) {
        int answerLength = 0;
        for(int i = 0; i < arr.length; i++) {
            answerLength += arr[i];
        }
        
        int[] answer = new int[answerLength];
        
        int idx = 0;
        for(int a : arr) {
            for(int i = 0; i < a;i++) {
                answer[idx] = a;
                idx++;
            }
        }
        
        return answer;
    }
}