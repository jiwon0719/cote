import java.io.*;
import java.util.*;

public class Main {
    static int answer, n, m;
    static int[][] map;
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(map[r][c] == 0) answer = Math.max(answer, bfs(r, c));
            }
        }

        System.out.println(answer);
    }

    static int bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isvisit = new boolean[n][m];

        queue.offer(new int[] {r, c, 0});
        isvisit[r][c] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];
            int dist = cur[2];

            if(map[curR][curC] == 1) return dist;

            for(int d = 0; d < 8; d++) {
                int nr = curR + dr[d];
                int nc = curC + dc[d];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m || isvisit[nr][nc]) continue;

                queue.offer(new int[] {nr, nc, dist + 1});
                isvisit[nr][nc] = true;
            }
        }

        return 0;
    }
}
