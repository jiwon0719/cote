//import java.io.*;
//import java.util.*;
//
//public class b_2193_이친수 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        Long[][] dp = new Long[N+1][2];
//
//        dp[1][0] = (long)0;
//        dp[1][1] = (long)1;
//
//        if(N >= 2) {
//            for(int i = 2; i <= N; i++) {
//                dp[i][0] = dp[i-1][0] + dp[i-1][1];
//                dp[i][1] = dp[i-1][0];
//            }
//        }
//
//        System.out.println(dp[N][0] + dp[N][1]);
//    }
//}

import java.io.*;
import java.util.*;

public class b_2193_이친수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Long[] dp = new Long[N+1];

        if(N >= 1) dp[1] = (long)1;
        if(N >= 2) dp[2] = (long)1;
        if(N >= 3) dp[3] = (long)2;

        for(int i = 3; i <= N; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        System.out.println(dp[N]);
    }
}
