import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //(1~1000)
		int[] dp = new int[N+1]; 
		
		if(N <= 2) {
			System.out.println(N);
			return;
		}
		
		dp[0] = 0 % 10007;
		dp[1] = 1 % 10007;
		dp[2] = 2 % 10007;
		for(int i = 3; i <= N; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % 10007;
		}
		
		System.out.println(dp[N]);
	}
}
