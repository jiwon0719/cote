import java.util.Scanner;

public class b_1788_피보나치수의확장_dp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int absN = Math.abs(n);
        long[] dp = new long[absN + 1];

        if(absN == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= absN; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000000;
        }

        if (dp[absN] == 0) {
            System.out.println(0);
            System.out.println(0);
        }

        else if(n < 0) { // 음수 인덱스
            if(absN % 2 == 0) {
                System.out.println(-1);
                System.out.println(dp[absN]);
            }
            else {
                System.out.println(1);
                System.out.println(dp[absN]);
            }
        }

        else { // 양수 인덱스
            System.out.println(1);
            System.out.println(dp[n]);
        }

    }
}
