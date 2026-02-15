import java.io.*;
import java.util.*;
// 탐험 시작 - 최소 필요 피로도 필요
// 탐험 끝남 - 소모 피로도 있음
// 현재 피로도 k
// 유저가 탐험할 수 있는 최대 던전수 return 

class Solution {
    
    public int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);   
        return answer;
    }
    
    public void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        answer = Math.max(answer, count);
        
        for(int i = 0; i < dungeons.length; i++) {
            if(k >= dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, visited, count + 1);    
                visited[i] = false;
            }
        }
    }
}