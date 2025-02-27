import java.util.Map;
import java.util.Scanner;

public class b_2579_계단오르기_dp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 계단의 개수
        int[] grade = new int[n+1]; // 계단별 점수 기록
        for(int i = 1; i <=n; i++) {
            grade[i] = sc.nextInt();
        }

        // dp[i][j] : i는 계단 번호,
        // j가 1일경우, 연속으로 1개 밟음 / j가 2일경우, 연속으로 2개 밞음
        int[][] dp = new int[n+1][3];

        dp[1][1] = grade[1];

        if(n >= 2) {
            dp[2][1] = grade[2];
            dp[2][2] = grade[1] + grade[2];
        }

        for(int i = 3; i <= n; i++) {
            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + grade[i]; // 이전에 연속으로 몇 개를 밟았는지 상관 없음. 큰 값 고르기
            dp[i][2] = dp[i-1][1] +grade[i]; // 이전에 연속으로 안밟은 경우로만 계산해야함.
        }

        System.out.println(Math.max(dp[n][1], dp[n][2]));
    }
}
