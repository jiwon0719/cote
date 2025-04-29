class Solution {
    public int solution(int[][] board, int k) {
        int answer = 0;
        
        int rows = board.length;
        
        for(int i = 0; i < rows; i++) {
            
            int cols = board[i].length;
            for(int j = 0; j < cols; j++) {
                if(i + j <= k) answer += board[i][j];
            }
        }
        
        
        return answer;
    }
}