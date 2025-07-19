import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 단어
        int M = Integer.parseInt(st.nextToken()); // 글

        Set<String> list = new HashSet<>();

        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            list.add(word);
        }

        for(int i = 0; i <  M; i++) {
            String s = br.readLine();
            String[] writes = s.split(",");

            for(String write : writes) {
                if(list.contains(write)) list.remove(write);
            }

            System.out.println(list.size());
        }
    }
}
