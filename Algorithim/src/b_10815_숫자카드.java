import java.io.*;
import java.util.*;

public class b_10815_숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] check = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();

        out : for(int i = 0; i < M; i++) {
            int left = 0;
            int right = N - 1;
            int mid;
            while(left <= right) {
                mid = (left + right) / 2;
                if(cards[mid] == check[i]) {
                    sb.append("1").append(" ");
                    continue out;
                }
            }
            sb.append("0").append(" ");
        }
    }
}
