import java.io.*;
import java.util.*;

public class b_15898_123더하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =  Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N =  Integer.parseInt(br.readLine());
            int[] dp = new int[N+1];
            dp[0] = 1;

            for(int i = 1; i <= N; i++) {
                dp[i] += dp[i-1];
            }

            for(int i = 2; i <= N; i++) {
                dp[i] += dp[i-2];
            }

            for(int i = 3; i <= N; i++) {
                dp[i] += dp[i-3];
            }

            System.out.println(dp[N]);
        }
    }
}
