import java.util.Scanner;

public class b_2579_계단오르기_dp_1차원배열로 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] grade = new int[n+1];
        for(int i = 1; i <= n; i++) {
            grade[i] = sc.nextInt();
        }

        int[] dp = new int[n+1];

        dp[1] = grade[1];
        if(n >= 2) {
            dp[2] = grade[1] + grade[2];
        }

        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2] + grade[i], //두 계단 전에서 직접 현재 온 경우(+2)
                             dp[i-3] + grade[i-1] + grade[i]); // 두 계단 전 + 한 계단 전 + 현재 (+1)
        }

        System.out.println(dp[n]);

    }
}
