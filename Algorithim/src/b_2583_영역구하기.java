import java.io.*;
import java.util.*;

public class b_2583_영역구하기 {

    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];




        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
    }
}
