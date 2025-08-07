import java.io.*;
import java.util.*;

public class b_1463_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        boolean[] isvisit = new boolean[N+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N] = 0;


        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        isvisit[N] = true;

        while(!queue.isEmpty()) {
            int num = queue.poll();

            if(num % 3 == 0 && !isvisit[num / 3]) {
                dp[num / 3] = Math.min(dp[num / 3], dp[num] + 1);
                queue.offer(num / 3);
                isvisit[num / 3] = true;
            }

            if(num % 2 == 0 && !isvisit[num / 2]) {
                dp[num / 2] = Math.min(dp[num / 2], dp[num] + 1);
                queue.offer(num / 2);
                isvisit[num / 2] = true;
            }

            if(num - 1 >= 0 && !isvisit[num - 1]) {
                dp[num - 1] = Math.min(dp[num - 1], dp[num] + 1);
                queue.offer(num - 1);
                isvisit[num - 1] = true;
            }
        }

        if(dp[1] == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(dp[1]);
    }
}
