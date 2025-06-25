import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int networkCount = 0;
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]){
                bfs(i, computers, visited);
                networkCount++;
            }
        }
        
        return networkCount;
    }
    
    
    public void bfs(int start, int[][] computers, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            // 현재 컴퓨터와 연결되어 있는 모든 컴퓨터 확인
            for(int i = 0; i < computers[current].length; i++) {
                if(computers[current][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
    
}