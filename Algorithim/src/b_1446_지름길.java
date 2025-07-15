import java.io.*;
import java.util.*;

public class b_1446_지름길 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[][] roads = new int[N][3]; // 시작위치, 도착위치, 거리
        for(int i = 0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            roads[i][0] = Integer.parseInt(st.nextToken());
            roads[i][1] = Integer.parseInt(st.nextToken());
            roads[i][2] = Integer.parseInt(st.nextToken());
        }

        // dp 배열 초기화
        int[] dp = new int[D+1];
        for(int i = 0; i <= D; i++) {
            dp[i] = i;
        }

        for(int i = 0; i <= D; i++) {
            if(i > 0) {
                dp[i] = Math.min(dp[i], dp[i-1] + 1);
            }

            for(int j = 0; j < roads.length; j++) {
                int start = roads[j][0];
                int end = roads[j][1];
                int length = roads[j][2];

                if(i == start && end <= D) {
                    dp[end] = Math.min(dp[end], dp[i] + length);
                }
            }
        }

        System.out.println(dp[D]);
    }

    public static class b_1788_피보나치수의확장_dp {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int absN = Math.abs(n);
            long[] dp = new long[absN + 1];

            if(absN == 0) {
                System.out.println(0);
                System.out.println(0);
                return;
            }

            dp[0] = 0;
            dp[1] = 1;

            for(int i = 2; i <= absN; i++) {
                dp[i] = (dp[i-1] + dp[i-2]) % 1000000000;
            }

            if (dp[absN] == 0) {
                System.out.println(0);
                System.out.println(0);
            }

            else if(n < 0) { // 음수 인덱스
                if(absN % 2 == 0) {
                    System.out.println(-1);
                    System.out.println(dp[absN]);
                }
                else {
                    System.out.println(1);
                    System.out.println(dp[absN]);
                }
            }

            else { // 양수 인덱스
                System.out.println(1);
                System.out.println(dp[n]);
            }

        }
    }
}