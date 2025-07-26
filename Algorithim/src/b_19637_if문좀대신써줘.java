import java.io.*;
import java.util.*;

public class b_19637_if문좀대신써줘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[][] standards = new String[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            standards[i][0] = st.nextToken(); // nickname
            standards[i][1] = st.nextToken(); // power
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int power = Integer.parseInt(br.readLine());

            // 이분탐색으로 시간복잡도를 줄이자
            int left = 0;
            int right = N - 1;
            while(left <= right) {
                int mid = (left + right) / 2;
                int standard = Integer.parseInt(standards[mid][1]);
                if(power > standard) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            sb.append(standards[left][0]);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
