import java.io.*;
import java.util.*;

public class b_4485_녹색옷을입은애가젤다지 {

    static int N;
    static int[][] map;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int tc = 1;
        while(true) {
            N = Integer.parseInt(br.readLine());

            if(N == 0) break;

            map = new int[N][N];
            for(int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            dijkstra();

            sb.append("Problem ").append(tc++).append(": ").append(dijkstra()).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static int dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        int[][] distance = new int[N][N];

        // 1. 거리 배열 초기화
        for(int i = 0; i < N; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        // 2. 시작점 pq 저장
        pq.offer(new int[] {0, 0, map[0][0]});

        // 3. 시작점 거리 저장
        distance[0][0] = map[0][0];

        // pq
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                if(distance[nr][nc] > dist + map[nr][nc]) {
                    distance[nr][nc] = dist + map[nr][nc];
                    pq.offer(new int[] {nr, nc, distance[nr][nc]});
                }
            }
        }
        return distance[N-1][N-1];
    }
}
