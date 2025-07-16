import java.io.*;
import java.util.*;

public class b_7490_0만들기 {

    static int N;
    static List<String> list;
    static String[] op = {"+", "-", " "};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            
            solution(1, "1");
            
            Collections.sort(list);
            for(String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    public static void solution(int start, String expression) {
        if(start == N) {
            String s = expression.replace(" ", "");
            if(cal(s)) list.add(s);
            return;
        }

        for(int i = 0; i < 3; i++) {
            solution(start + 1, expression + op[i] + Integer.toString(start + 1));
        }

    }

    public static boolean cal(String s) {
        StringTokenizer st = new StringTokenizer(s, "+|-", true);
        return true;
    }
}
