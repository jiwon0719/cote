import java.util.Scanner;

public class b_1912_연속합_dp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];

        // input 및 초기화
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            dp[i] = arr[i];
        }

        // 점화식
        // dp[i] : i번째 값이 연속된 부분수열에서 가장 마지막 값이 되었을때 최댓값 저장
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i-1]+ arr[i]);
        }

        // 최댓값 구하기
        int max = dp[0];
        for(int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
