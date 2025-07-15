import java.io.*;
import java.util.*;

public class b_17266_어두운굴다리 {

    static int N, M;
    static int[] bridgeLamp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 굴다리의 길이
        M = Integer.parseInt(br.readLine()); // 가로등의 개수

        bridgeLamp = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            bridgeLamp[i] = Integer.parseInt(st.nextToken());
        }

        // 이분탐색으로 적절한 높이 찾기
        int left = 0;
        int right = N;
        int answer = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(check(mid)) { // 충분히 밝힐 수 있다면
                right = mid - 1; // 조금 더 높이 줄여서 최소높이 찾기
                answer = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean check(int height) {
        int prev = 0;

        for(int i = 0; i < M; i++) {
            if(bridgeLamp[i] - height <= prev) {
                prev = bridgeLamp[i] + height;
            } else {
                return false;
            }
        }

        return N - prev <= 0;
    }
}
