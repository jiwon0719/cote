import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        boolean[] brokens = new boolean[10];

        if(M > 0) {
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                int b = Integer.parseInt(st.nextToken());
                brokens[b] = true;
            }
        }

        int answer = Math.abs(N - 100);

        for(int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            boolean isBreak = false;

            for(int j = 0; j < str.length(); j++) {
                if(brokens[str.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }

            if(!isBreak) {
                int cnt = Math.abs(N - i) + str.length();
                answer = Math.min(answer, cnt);
            }
        }

        System.out.println(answer);
    }
}
