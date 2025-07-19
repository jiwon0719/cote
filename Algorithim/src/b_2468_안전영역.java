import java.io.*;
import java.util.*;

public class b_2468_안전영역 {

    static int N;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int maxHeight = 0;
        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[r][c]);
            }
        }

        int answer = 1;

        for(int rainLevel = 1; rainLevel <= maxHeight; rainLevel++) {
            answer = Math.max(answer, countSafeAreas(rainLevel));
        }

        System.out.println(answer);
    }

    public static int countSafeAreas(int rainLevel) {
        boolean[][] visited = new boolean[N][N];
        int safeAreaCount = 0;

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(map[r][c] > rainLevel && !visited[r][c]) {
                    dfs(r, c, rainLevel, visited);
                    safeAreaCount++;
                }
            }
        }

        return safeAreaCount;
    }

    public static void dfs(int r, int c, int rainLevel, boolean[][] visited) {
        if(r < 0 || r >= N || c < 0 || c >= N ||
                visited[r][c] || map[r][c] <= rainLevel) {
            return;
        }

        visited[r][c] = true;

        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            dfs(nr, nc, rainLevel, visited);
        }
    }
}