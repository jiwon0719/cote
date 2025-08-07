import java.io.*;
import java.util.*;

public class b_1463_1로만들기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        for(int i = 2; i <= N; i++) {
            int minCnt = dp[i-1] + 1;
            if(i % 2 == 0) minCnt = Math.min(minCnt, dp[i/2] + 1);
            if(i % 3 == 0) minCnt = Math.min(minCnt, dp[i/3] + 1);

            dp[i] = minCnt;
        }

        System.out.println(dp[N]);
        for(int i = 1; i <= N; i++) {
            System.out.print(dp[i] + " ");
        }
    }
}
