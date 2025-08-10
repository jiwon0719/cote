import java.io.*;
import java.util.*;

public class b_11053_가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        // 점화식 : i번째 숫자가 가장 끝에 위치하는 가장 긴 증가하는 부분 수열의 개수를 저장
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            if(max < dp[i]) max = dp[i];
        }
        System.out.println(max);
    }
}
