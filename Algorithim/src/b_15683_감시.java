import java.io.*;
import java.util.*;

public class b_15683_감시 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][][] mode =
            {       {{0}},
                    {{0}, {1}, {2}, {3}}, // 1번
                    {{2, 3}, {0, 1}}, // 2번
                    {{0, 3}, {1, 3}, {1, 2}, {0, 2}}, // 3번
                    {{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}}, // 4번
                    {{0, 1, 2, 3}} // 5번
            };
    static ArrayList<Node> cctv;
    static class Node {
        int r, c, type;
        public Node(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }
    static int N, M, answer;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cctv = new ArrayList<>();
        int zero_cnt = 0;
        map = new int[N][M];

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] >= 1 && map[r][c] <= 5) {
                    cctv.add(new Node(r, c, map[r][c]));
                } else if(map[r][c] == 0) zero_cnt++;
            }
        }

        answer = zero_cnt;
        comb(0, cctv.size(), map);
        System.out.println(answer);
    }

    public static void comb(int depth, int n, int[][] map) {
        if(depth == n) {
            int cnt = check(map);
            answer = Math.min(answer, cnt);
            return;
        }

        int cctv_type = cctv.get(depth).type;
        int r = cctv.get(depth).r;
        int c = cctv.get(depth).c;

        for(int i = 0; i < mode[cctv_type].length;i++) {
            int[][] map_copy = new int[N][M];
            for(int k = 0; k < N; k++) {
                map_copy[k] = map[k].clone();
            }

            for(int j = 0; j < mode[cctv_type][i].length; j++) {
                int d = mode[cctv_type][i][j];

                int nr = r + dr[d];
                int nc = c + dc[d];
                // 갈 수 있는 만큼 전진하기
                while(true) {
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M) break;

                    if(map[nr][nc] == 6) break;

                    map_copy[nr][nc] = -1;
                    nr += dr[d];
                    nc += dc[d];
                }
            }

            comb(depth+1, n, map_copy);
        }
    }

    public static int check(int[][] map) {
        int cnt = 0;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(map[r][c] == 0) cnt++;
            }
        }
        return cnt;
    }
}
