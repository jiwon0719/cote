import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] keyPad = {{1, 2, 3}, 
                          {4, 5, 6}, 
                          {7, 8, 9}, 
                          {10, 0, 11}};
        
        int[] curNum = {10, 11}; // 왼, 오
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if(number == 1 || number == 4 || number == 7 || number == 10) {
                sb.append("L");
                curNum[0] = number;
            } else if(number == 3 || number == 6 || number == 9 || number == 11) {
                sb.append("R");
                curNum[1] = number;
            } else {
                // 왼손과 오른손 각각 bfs돌려서 누가 더 가까운지 찾기
                // 우선 왼손과 오른손 위치를 알아야 함.
                int[] curL = checkCur(curNum[0], keyPad);
                int[] curR = checkCur(curNum[1], keyPad);
                
                int leftCnt = bfs(curL[0], curL[1], number, keyPad);
                int rightCnt = bfs(curR[0], curR[1], number, keyPad);
                
                if(leftCnt < rightCnt) {
                    sb.append("L");
                    curNum[0] = number;
                } else if(leftCnt > rightCnt) {
                    sb.append("R");
                    curNum[1] = number;
                } else {
                    if(hand.equals("left")) {
                        sb.append("L");
                        curNum[0] = number;
                    } else {
                        sb.append("R");
                        curNum[1] = number;
                    }
                }
            }
        }
        
        answer = sb.toString();
        
        return answer;
    }
    
    public int[] checkCur (int curNum, int[][] keyPad) {
        int[] arr = new int[2];

        
        for(int r = 0; r < 4; r++) {
            for(int c = 0; c < 3; c++) {
                if(keyPad[r][c] == curNum) {
                    arr[0] = r;
                    arr[1] = c;
                    return arr;
                }
            }
        }
        
        return arr;
    }
    
    public int bfs(int r, int c, int number, int[][] keyPad) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isvisited = new boolean[4][3];
        queue.offer(new int[]{r, c, 0});
        isvisited[r][c] = true;
        
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];
            int cnt = cur[2];
            
            if(keyPad[curR][curC] == number) return cnt;
            
            for(int d = 0; d < 4; d++) {
                int nr = curR + dr[d];
                int nc = curC + dc[d];
                
                if(nr < 0 || nr >= 4 || nc < 0 || nc >= 3 || isvisited[nr][nc]) continue;
                
                if(keyPad[nr][nc] == number) return cnt + 1;
                
                queue.offer(new int[] {nr, nc, cnt + 1});
                isvisited[nr][nc] = true;
            }
        }
        
        return 0;
    }
}