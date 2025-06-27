import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        queue.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];
            
            if(r == n-1 && c == m-1) {
                return dist;
            }
            
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(nr < 0 || nr >= n || nc < 0 || nc >= m 
                   || maps[nr][nc] == 0 || visited[nr][nc]) continue;
                
                queue.offer(new int[] {nr, nc, dist + 1});
                visited[nr][nc] = true;
            }
        }
        
        // bfs 끝났는데 리턴 안된건 결국 도착지 못갔음
        return -1;
    }
}