import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = 0;
            if(command.equals("push")) {
                num = Integer.parseInt(st.nextToken());
                deque.offer(num);
            }
            else if(command.equals("pop")) {
                if(!deque.isEmpty()) System.out.println(deque.poll());
                else System.out.println(-1);
            }
            else if(command.equals("size")) {
                System.out.println(deque.size());
            }
            else if(command.equals("empty")) {
                if(deque.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            else if(command.equals("front")) {
                if(!deque.isEmpty()) System.out.println(deque.peekFirst());
                else System.out.println(-1);
            }
            else if(command.equals("back")) {
                if(!deque.isEmpty()) System.out.println(deque.peekLast());
                else System.out.println(-1);
            }

        }
    }
}
