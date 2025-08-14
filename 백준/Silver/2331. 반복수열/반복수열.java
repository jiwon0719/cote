import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        map.put(A, 0);
        list.add(A);

        int idx = 0;
        while(true) {
            String current = Integer.toString(list.get(idx));
            int next = 0;
            for(char ch : current.toCharArray()) {
                next += (int) Math.pow(ch - '0', P);
            }
            if(map.containsKey(next)) {
                System.out.println(map.get(next));
                return;
            }
            list.add(next);
            map.put(next, list.indexOf(next));
            idx++;
        }
    }
}
