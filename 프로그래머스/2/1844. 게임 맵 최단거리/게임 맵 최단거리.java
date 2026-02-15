import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        queue.add(new int[] {0, 0, 0});
        visited[0][0] = true;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int curR = arr[0];
            int curC = arr[1];
            int dist = arr[2];
            
            if(curR == n - 1 && curC == m - 1) {
                return dist + 1;
            }
            
            for(int d = 0; d < 4; d++) {
                int nr = curR + dr[d];
                int nc = curC + dc[d];
                
                if(nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] || maps[nr][nc] == 0) continue;
                
                queue.add(new int[] {nr, nc, dist + 1});
                visited[nr][nc] = true;
            }
        }
        
        return -1;
    }
}