import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) { // 방문하지 않은 컴퓨터를 발견하면
                bfs(computers, visited, i); // 네트워크 형성
                answer++; // bfs가 종료되면 하나의 네트워크가 형성된 것
            }
        }
        
        return answer;
    }   
    
    public void bfs(int[][] computers, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start); 
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            for(int i = 0; i < computers[current].length; i++) {
                if(computers[current][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}