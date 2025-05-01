class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];
            
            int ans = 10000000;
            for(int j = s; j <= e; j++) {
                int num = arr[j];
                if(num > k) ans = Math.min(ans, num);  
            }
            
            answer[i] = (ans != 10000000 ? ans : -1);
        }
        
        
        
        
        return answer;
    }
}