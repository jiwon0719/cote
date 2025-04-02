import java.io.*;
import java.util.*;

public class b_21921_블로그_시간초과 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int MaxCnt = 0; // 최대 방문자 수
        int period = 0; // 기간
        for(int i = 0; i <= N - X; i++) {
            int cnt = 0;
            int index = i;
            for(int j = 0; j < X; j++) {
                cnt += arr[index++];
            }

            if(MaxCnt < cnt) {
                MaxCnt = cnt;
                period = 1;
            } else if (MaxCnt == cnt) {
                period++;
            }
        }

        if(MaxCnt == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(MaxCnt);
            System.out.println(period);
        }
    }
}
