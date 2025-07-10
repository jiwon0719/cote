import java.io.*;
import java.util.*;

public class b_17484_진우의달여행 {

    private static int[] dr = {1, 1, 1};
    private static int[] dc = {-1, 0, 1};
    private static int[][] map;
    private static int N;
    private static int M;

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < M; i++) {
            answer = Math.min(answer, bfs(i));
        }

        System.out.println(answer);
    }

    private static int bfs(int i) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][][] isVisited = new boolean[N][M][3];
        queue.offer(new int[] {0 , i, map[0][i], -1}); // 행, 열, 연료, 이동방향(0 처음, 1 좌하, 2 하, 3 우하)

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int r =  current[0];
            int c = current[1];
            int fuel = current[2];
            int preD = current[3];

            // 종료 조건
            if(r == N-1) {
                return fuel;
            }

            for(int d = 0; d < 3; d++) {
                if(preD == d) continue;

                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc][d]) continue;

                queue.offer(new int[]{nr, nc, fuel + map[nr][nc], d});
                isVisited[nr][nc][d] = true;
            }
        }
        return 0;
    }
}
