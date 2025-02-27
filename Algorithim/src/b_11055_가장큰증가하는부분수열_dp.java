import java.util.Scanner;

public class b_11055_가장큰증가하는부분수열_dp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] dp = new int[N];

        // input 및 초기화
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            dp[i] = arr[i];
        }

        // dp 점화식
        // dp[i] : 해당 인덱스 값이 증가하는 부분수열에서 가장 마지막 값(=가장 큰 값) 이 되었을때 합이 가장 큰 것을 저장한다.
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        // 가장 큰 값 출력
        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
