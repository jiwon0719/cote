import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_14501_퇴사_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N+1]; // 각 상담을 완료하는데 걸리는 기간
        int[] P = new int[N+1]; // 각 상담을 했을 때 받을 수 있는 금액

        // 입력 받기
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // DP 배열: dp[i]는 i일부터 시작했을 때 얻을 수 있는 최대 수익
        int[] dp = new int[N+2]; // N+1일에 퇴사이므로 N+2 크기로 설정

        // 뒤에서부터 계산 (퇴사일부터 거꾸로)
        for (int i = N; i >= 1; i--) {
            int nextDay = i + T[i]; // 현재 상담이 끝나는 날

            if (nextDay <= N+1) { // 퇴사일까지 상담이 가능한 경우
                // 현재 상담을 선택하는 경우와 선택하지 않는 경우 중 최댓값 선택
                dp[i] = Math.max(P[i] + dp[nextDay], dp[i+1]);
            } else { // 퇴사일을 넘어가는 경우
                dp[i] = dp[i+1]; // 현재 상담은 선택할 수 없음
            }
        }

        // 결과 출력: 1일부터 시작했을 때의 최대 수익
        System.out.println(dp[1]);
        br.close();
    }
}