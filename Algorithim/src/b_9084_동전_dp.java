import java.util.Scanner;

public class b_9084_동전_dp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // 동전의 가지 수
            int[] coin = new int[N]; // 동전 배열 저장
            for(int i = 0; i < N; i++) {
                coin[i] = sc.nextInt();
            }
            int won = sc.nextInt(); // 만들어야할 값

            int[] dp = new int[won + 1]; // i : i원을 만들기 위해 가능한 경우의 수를 저장

            // 초기값 세팅
            for(int i = 0; i < N; i++) {
                dp[i] = 1;
            }

            // 점화식

            for(int i = coin[N-1] + 1; i <= won; i++) {
                int cnt = 0;
                for(int j = 0; j < N; j++) {
                    cnt += dp[i-j];
                }
                dp[i] = cnt;
            }

            System.out.println(dp[won]);
        }
    }
}
