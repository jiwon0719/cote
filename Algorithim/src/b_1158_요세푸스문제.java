import java.io.*;
import java.util.*;

public class b_1158_요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int num = 0;
        for(int i = 0; i <= N-1; i++) {
            sb.append((num + K) % (N + 1)).append(", ");
            num = (num + K) % (N + 1);
        }
        sb.append((num + K) % (N + 1));
        sb.append(">");

        System.out.println(sb);
    }
}