import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b_1926_그림_BFS {

    private static int N, M; // N 세로(행), M 가로(열)
    private static int[][] graph;
    private static boolean[][] isvisited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N][M];
        isvisited = new boolean[N][M];

        // input
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                graph[r][c] = sc.nextInt();
            }
        }

        // bfs
        // cnt는 bfs를 새로 시작할때마다 == 즉 새로운 그림을 찾기 시작할때마다 ++
        // maxExtent는 bfs로 반환받은 그림 넒이와 비교하여  가장 큰 값을 저장
        int cnt = 0;
        int maxExtent = 0;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(graph[r][c] == 1 && !isvisited[r][c]) { // 그림이며, 아직 방문하지 않은 경우
                    isvisited[r][c] = true;
                    int extent = bfs(r, c);
                    cnt++;

                    if(extent > maxExtent) maxExtent = extent;
                }
            }
        }

        // 출력
        System.out.println(cnt);
        System.out.println(maxExtent);
    }

    private static int bfs(int r, int c) {
        int extent = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int curR = current[0];
            int curC = current[1];

            // 사방탐색
            for(int d = 0; d < 4; d++) {
                int nr = curR + dr[d];
                int nc = curC + dc[d];

                // 범위 체크 && 그림인지 && 방문하지 않았는지
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || graph[nr][nc] != 1 || isvisited[nr][nc]) continue;

                isvisited[nr][nc] = true;
                queue.add(new int[] {nr, nc});
                extent++;
            }
        }
        return extent;
    }
}
