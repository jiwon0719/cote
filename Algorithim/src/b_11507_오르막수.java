import java.io.*;
import java.util.*;

public class b_11507_오르막수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];

        for(int i = 0; i <= 9; i++) {
            dp[1][i] = 1 % 10007;
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j <= 9; j++) {
                for(int k = 0; k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10007;
                }
            }
        }

        int answer = 0;
        for(int i = 0; i <= 9; i++) {
            answer = (answer + dp[N][i]) % 10007;
        }

        System.out.println(answer % 10007);
    }
}
