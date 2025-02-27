import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b_7569_토마토_BFS {

    static int N, M, H;
    static int[][][] graph;
    static boolean [][][] isvisited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // 가로(열)
        N = sc.nextInt(); // 세로(행)
        H = sc.nextInt(); // 높이
        graph = new int[N][M][H];
        isvisited = new boolean[N][M][H];

        int maxDate = 0;

        // input
        for(int h = 0; h < H; h++) {
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < M; c++) {
                    graph[r][c][h] = sc.nextInt();
                    if(graph[r][c][h] == 1) { // 시작점을 한번에 큐에 넣고 BFS 돌리기
                        queue.add(new int[] {r, c, h});
                        isvisited[r][c][h] = true;
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int curR = current[0];
            int curC = current[1];
            int curH = current[2];

            // 상하좌우 사방탐색
            for(int d = 0; d < 4; d++) {
                int nr = curR + dr[d];
                int nc = curC + dc[d];

                // 범위탐색, 토마토가 없거나, 이미 익었거나
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || graph[nr][nc][curH] == -1 || isvisited[nr][nc][curH]) continue;

                queue.add(new int[] {nr, nc, curH});
                isvisited[nr][nc][curH] = true;
                graph[nr][nc][curH] = graph[curR][curC][curH] + 1;
            }

            // 위아래
            for(int i = -1; i < 2; i+=2) {
                int nh = curH + i;

                // 범위탐색
                if(nh < 0 || nh >= H || graph[curR][curC][nh] == - 1 || isvisited[curR][curC][nh]) continue;

                queue.add(new int[] {curR, curC, nh});
                isvisited[curR][curC][nh] = true;
                graph[curR][curC][nh] = graph[curR][curC][curH] + 1;
            }
        }

        for(int h = 0; h < H; h++) {
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < M; c++) {
                    if(graph[r][c][h] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    if(graph[r][c][h] > maxDate) {
                        maxDate = graph[r][c][h];
                    }
                }
            }
        }

        System.out.println(maxDate - 1);
    }
}
