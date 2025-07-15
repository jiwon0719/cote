import java.io.*;
import java.util.*;

public class b_14503_로봇청소기 {

    static int[] dr = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dc = {0, 1, 0, -1};
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(R, C, D));
    }

    public static int bfs(int R, int C, int D) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][M];

        queue.add(new int[] {R, C, 0});
        visited[R][C] = true;

        int answer = 0;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int direction = current[2];

            // 1. 현재 칸이 청소되지 않았으면 청소한다.
            if(map[r][c] == 0) {
                map[r][c] = -1;
                answer++;
            }

            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(map[nr][nc] == 0) {

                }
            }
            // 2-1. 현재 칸의 주변 4칸이 모두 청소된 경우
            // 2-2. 현재 칸의 주변 4칸 중 청소 안 된 칸이 있는 경우
        }

        return answer;
    }
}
