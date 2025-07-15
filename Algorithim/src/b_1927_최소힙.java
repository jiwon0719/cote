import java.io.*;
import java.util.*;

public class b_1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 0 : 가장 작은 값을 출력해라. 없으면 0을 출력
        // 그외 : 해당 숫자를 넣어라.

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < N;i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(!pq.isEmpty()) {
                    sb.append(pq.poll()).append('\n');
                } else sb.append("0").append("\n");
            } else {
                pq.add(num);
            }
        }

        System.out.print(sb.toString());
    }
}
