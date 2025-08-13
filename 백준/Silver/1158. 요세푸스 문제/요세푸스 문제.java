import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int idx = 0;
        for(int i = 0; i < N-1; i++) {
            idx = (idx + K - 1) % list.size();
            sb.append(list.get(idx)).append(", ");
            list.remove(list.get(idx));
        }
        sb.append(list.get(0));
        sb.append(">");

        System.out.println(sb);
    }
}