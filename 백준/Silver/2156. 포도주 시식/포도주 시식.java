import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[N+1][3];

        dp[1][0] = 0; // 마시지 않음
        dp[1][1] = arr[1]; // 마심, 이전 와인은 마시지 않음
        dp[1][2] = arr[1]; // 마심, 이전 와인도 마심(2번째 전 와인은 마시지 않음)

        if(N >= 2) {
            for(int i = 2; i <= N; i++) {
                dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]),dp[i-1][2]);
                dp[i][1] = dp[i-1][0] + arr[i];
                dp[i][2] = dp[i-1][1] + arr[i];
            }
        }

        System.out.println(Math.max(Math.max(dp[N][0], dp[N][1]), dp[N][2]));
    }
}
