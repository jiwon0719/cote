import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // (1~10^6)
		int[] dp = new int[N+1];
		
		for(int i = 2; i<= N; i++) {
			int minCnt = dp[i-1] + 1;
			
			if(i % 2 == 0) minCnt = Math.min(minCnt, dp[i/2] + 1);
			if(i % 3 == 0) minCnt = Math.min(minCnt, dp[i/3] + 1);
			dp[i] = minCnt;
		}
		System.out.println(dp[N]);
	}
}
