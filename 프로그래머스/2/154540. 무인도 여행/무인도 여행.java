import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int[][] map = new int[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < maps.length; i++) {
            String[] str = maps[i].split("");
            for(int j = 0; j < str.length; j++) {
                if(str[j].equals("X")) map[i][j] = -1;
                else map[i][j] = Integer.parseInt(str[j]);
            }
        }
        
        // for(int r = 0; r < map.length; r++) {
        //     for(int c = 0; c < map[r].length; c++) {
        //         System.out.print(map[r][c] + " ");
        //     }
        //     System.out.println();
        // }
        
        for(int r = 0; r < map.length; r++) {
            for(int c = 0; c < map[r].length; c++) {
                if(map[r][c] != -1 && !visited[r][c]) { // 섬이고, 방문하지 않은 경우
                    int days = dfs(map, visited, r, c);
                    list.add(days);
                }
            }
        }
        
        if(list.size() == 0) {
            return new int[] {-1};
        }
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        int idx = 0;
        for(int i : list) {
            answer[idx++] = i;
        }
        
        return answer;
    }
    
    public static int dfs(int[][] map, boolean[][] visited, int r, int c) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        if(r < 0 || r >= map.length || c < 0 || c >= map[0].length ||visited[r][c] || map[r][c] == -1) {
            return 0;
        }
        
        visited[r][c] = true;
        int currentFood = map[r][c];
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            currentFood += dfs(map, visited, nr, nc);
        }
        
        return currentFood;
    } 
}