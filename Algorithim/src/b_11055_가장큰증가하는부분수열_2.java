import java.io.*;
import java.util.*;

public class b_11055_가장큰증가하는부분수열_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + arr[i]);
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            if(max < dp[i]) max = dp[i];
        }

        System.out.println(max);
    }
}
