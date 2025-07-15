import java.io.*;
import java.util.*;

public class b_7490_0만들기 {

    static int N;
    static List<String> list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            
            solution(1, "1");
            
            Arrays.(list);
            
            System.out.println();
        }
    }

    public static void solution(int start, String expression) {
        

        if(start == N) {
            for(String s : list) {
                System.out.println(s);
            }
        }

        solution(start)
    }
}
