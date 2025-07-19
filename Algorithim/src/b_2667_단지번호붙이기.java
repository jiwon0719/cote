import java.io.*;
import java.util.*;

public class b_2667_단지번호붙이기 {

    static int N;
    static boolean[][] visited;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int r = 0; r < N; r++) {
            String[] str = br.readLine().split("");
            for(int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(str[c]);
            }
        }

        List<Integer> list = new ArrayList<>();
        int answer = 0;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(map[r][c] == 1 && !visited[r][c]) {
                    int count = dfs(r, c);
                    list.add(count);
                    answer++;
                }
            }
        }

        System.out.println(answer);
        Collections.sort(list);
        for(int i : list) {
            System.out.println(i);
        }
    }

    public static int dfs(int r, int c) {
        if(r < 0 || r >= N || c < 0 || c >= N || visited[r][c] || map[r][c] == 0) return 0;

        visited[r][c] = true;

        int currentCount = 1;
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            currentCount += dfs(nr, nc);
        }

        return currentCount;
    }
}
