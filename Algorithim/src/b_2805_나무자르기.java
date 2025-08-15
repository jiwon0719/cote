import java.io.*;
import java.util.*;

public class b_2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long left = 1;
        long right = 0;
        long mid;
        long ans = 0;

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if(right < trees[i]) right = trees[i];
        }

        while(left <= right) {
            mid = (left + right) / 2; // H

            long cnt = 0;
            for(int i = 0; i < N; i++) {
                if(trees[i] - mid > 0) cnt += trees[i] - mid;
            }

            if(cnt >= M) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
