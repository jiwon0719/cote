import java.io.*;
import java.util.*;

public class b_14940_쉬운최단거리 {

    static int N, M;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int startR = 0, startC = 0;
        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                int num = Integer.parseInt(st.nextToken());
                map[r][c] = num;
                if(map[r][c] == 2) {
                    startR = r;
                    startC = c;
                }
            }
        }

        int[][] answer = new int[N][M];

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(map[r][c] == 0) answer[r][c] = 0;
                else answer[r][c] = -1;
            }
        }

        bfs(startR, startC, answer);

        StringBuilder sb = new StringBuilder();
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                sb.append(answer[r][c] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static int bfs(int r, int c, int[][] answer) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isvisit = new boolean[N][M];

        queue.offer(new int[] {r, c, 0});
        isvisit[r][c] = true;
        answer[r][c] = 0; // 목표지점 거리는 0

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int curR = current[0];
            int curC = current[1];
            int dist = current[2];

            for(int d = 0; d < 4; d++) {
                int nr = curR + dr[d];
                int nc = curC + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || isvisit[nr][nc] || map[nr][nc] == 0) continue;

                isvisit[nr][nc] = true;
                answer[nr][nc] = dist + 1;
                queue.offer(new int[] {nr, nc, dist + 1});
            }
        }

        return -1;
    }
}
