import java.util.Scanner;

public class b_11727_2n타일링_dp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 런타임 에러 해결
        if(n == 1) {
            System.out.println(1);
            return;
        }

        // dp 알고리즘
        long[] dp = new long[n+1];

        // 초기값 세팅
        dp[1] = 1;
        dp[2] = 3;
        // 점화식
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + (2 * dp[i-2])) % 10007 ; // 모듈러 연산
        }

        System.out.println(dp[n] % 10007);
    }
}
