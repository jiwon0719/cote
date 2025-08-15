import java.io.*;
import java.util.*;

public class b_1654_랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long left = 1;
        long right = 0;
        long mid;
        long ans = 0;

        int[] lens = new int[K];
        for(int i = 0; i < K; i++) {
            lens[i] = Integer.parseInt(br.readLine());
            if(right < lens[i]) right = lens[i];
        }

        while(left <= right) {
            int cnt = 0;
            mid = (left + right) / 2; // 이 길이로 잘라볼게
            for(int i = 0; i < K; i++) {
                cnt += (lens[i] / mid);
            }

            if(cnt >= N) { // 내가 원하는 개수(N)를 맞춤! > mid 길이를 더 늘려볼까?
                left = mid + 1;
                ans = Math.max(ans, mid);

            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
