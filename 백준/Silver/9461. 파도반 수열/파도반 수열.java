import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            long[] dp = new long[N+1];

            dp[0] = 0;
            dp[1] = 1;
            if(N >= 2) dp[2] = 1;
            if(N >= 3) dp[3] = 1;
            if(N >= 4) dp[4] = 2;
            if(N >= 5) dp[5] = 2;
            if(N >= 6) {
                for(int i = 6; i <= N; i++) {
                    dp[i] = dp[i-1] + dp[i-5];
                }
            }

            System.out.println(dp[N]);
        }
    }
}
