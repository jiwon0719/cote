import java.io.*;
import java.util.*;

public class b_10844_쉬운계단수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];

        dp[1][0] = 0;
        for(int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= N; i++) {

            dp[i][0] = dp[i-1][1] % 1000000000;
            for(int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
            dp[i][9] = dp[i-1][8] % 1000000000;
        }

        int answer = 0;
        for(int i = 0; i < 10; i++) {
            answer = (answer + dp[N][i]) % 1000000000;
        }

        System.out.println(answer % 1000000000);
    }
}
