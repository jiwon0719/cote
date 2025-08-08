import java.io.*;
import java.util.*;

public class b_9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N];
            for(int r = 0; r < 2; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[N][3];
            dp[0][0] = arr[0][0]; // 위
            dp[0][1] = arr[1][0]; // 아래
            dp[0][2] = 0;  // 아무것도 선택 X

            if(N >= 2) {
                for(int i = 1; i < N; i++) {
                    dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]) + arr[0][i];
                    dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + arr[1][i];
                    dp[i][2] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
                }
            }

            int answer = Math.max(Math.max(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);
            System.out.println(answer);
        }
    }
}
