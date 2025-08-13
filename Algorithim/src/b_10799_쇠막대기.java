import java.io.*;
import java.util.*;

public class b_10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        char pre = 0;
        for(char ch : str.toCharArray()) {
            if(ch == '(') {
                stack.push(ch);
            }
            else if(ch == ')' && pre == '(') {
                stack.pop();
                answer += stack.size();
            }
            else if(ch == ')' && pre != '(') {
                stack.pop();
                answer ++;
            }
            pre = ch;
        }

        System.out.println(answer);
    }
}
