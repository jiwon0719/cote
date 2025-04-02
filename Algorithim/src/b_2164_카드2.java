import java.io.*;
import java.util.*;

public class b_2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }

        if(queue.size() == 1) {
            System.out.println(N);
            return;
        }

        int sequence = 1;
        while(!queue.isEmpty()) {
            int card = queue.poll();

            if(queue.size() == 0) {
                System.out.println(card);
                return;
            }

            if((sequence % 2) == 0) {
                queue.add(card);
            }
            sequence++;
        }
    }
}
