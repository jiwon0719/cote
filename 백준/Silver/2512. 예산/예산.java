import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] regions = new int[N];
        st = new StringTokenizer(br.readLine());
        int right = 0;
        for(int i = 0; i < N; i++) {
            regions[i] = Integer.parseInt(st.nextToken());
            if(right < regions[i]) right = regions[i];
        }
        int totalBudget = Integer.parseInt(br.readLine());

        int answer = 0;
        int left = 0;
        while(left <= right) {
            int mid = (left + right) / 2;

            int sum = 0;
            for(int i = 0; i < N; i++) {
                if(regions[i] <= mid) sum += regions[i];
                else sum += mid;
            }

            if(sum <= totalBudget) {
                answer = mid;
                left = mid + 1;
            } else {
                answer = mid - 1;
                right = mid - 1;
            }
        }


        System.out.println(answer);
    }
}
