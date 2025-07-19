import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R, C, D;
    static int[][] arr;
    static int count = 1;
    static int[] dr = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        solution(R, C, D);
        System.out.println(count);
    }

    public static void solution(int r, int c, int dir) {
        arr[r][c] = -1;

        for (int d = 0; d < 4; d++) {
            dir = (dir + 3) % 4;

            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
                if (arr[nr][nc] == 0) {
                    count++;
                    solution(nr, nc, dir);
                    return;
                }
            }
        }

        int d = (dir + 2) % 4; //반대 방향으로 후진
        int br = r + dr[d];
        int bc = c + dc[d];
        if (br >= 0 && bc >= 0 && br < N && bc < M && arr[br][bc] != 1) {
            solution(br, bc, dir); //후진이니까 바라보는 방향은 유지
        }
    }
}
