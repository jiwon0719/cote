class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        // 2차원 배열(map) 으로 저장하기
        char[][] map = new char[m][n];
        for(int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        
        while(true) {
            // 2차원 배열(deleteMap) 초기화
            boolean[][] deleteMap = new boolean[m][n];
            boolean hasDeleted = false;
            
            // 1. 블럭 찾기
            for(int r = 0; r < m - 1; r++) {
                for(int c = 0; c < n - 1; c++) {
                    char curr = map[r][c];
                    if(curr != 'X' &&
                       curr == map[r+1][c] && 
                       curr == map[r][c+1] && 
                       curr == map[r+1][c+1]) {
                        
                        deleteMap[r][c] = true;
                        deleteMap[r+1][c] = true;
                        deleteMap[r][c+1] = true;
                        deleteMap[r+1][c+1] = true;
                        hasDeleted = true;
                    }
                }
            }
            
            // 2. 블럭 제거
            if (!hasDeleted) break; 
            
            int deleteCount = 0;
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (deleteMap[r][c]) {
                        map[r][c] = 'X';  
                        deleteCount++;
                    }
                }
            }
            answer += deleteCount;
            
            // 3. 블럭 내리기
            for(int c = 0; c < n; c++) {
                int emptyRow = m-1;
                
                for(int r = m-1; r >= 0; r--) {
                    if(map[r][c] != 'X') {
                        map[emptyRow--][c] = map[r][c];
                    }
                }
                
                for(int r = emptyRow; r >= 0; r--) {
                    map[r][c] = 'X';
                }
            }
        } // while
        
        return answer;
    }
}