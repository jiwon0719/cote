import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        out : for(int t = 0; t < T; t++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(Character ch : str.toCharArray()) {
                if(ch == '(') stack.push('(');
                else if(!stack.isEmpty() && ch == ')') stack.pop();
                else if(stack.isEmpty() && ch == ')') {
                    System.out.println("NO");
                    continue out;
                }
            }
            if(stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}