import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Long[][] dp = new Long[N+1][2];

        dp[1][0] = (long)0;
        dp[1][1] = (long)1;

        if(N >= 2) {
            for(int i = 2; i <= N; i++) {
                dp[i][0] = dp[i-1][0] + dp[i-1][1];
                dp[i][1] = dp[i-1][0];
            }
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }
}
