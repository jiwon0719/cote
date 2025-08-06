import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
            list[i].add(Integer.parseInt(br.readLine()));
        }

        boolean[] isvisit = new boolean[N];
        int count = 0;
        int current = 0;
        while(true) {
            count++;
            int next = list[current].get(0);

            if(isvisit[next]) break;

            if(!isvisit[next]) {
                isvisit[next] = true;
                current = next;
            }

            if(next == K) {
                System.out.println(count);
                return;
            }


        }

        System.out.println(-1);
    }
}
