import java.io.*;
import java.util.*;

public class Main {
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
}
