import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()) {
            if(ch >= 'A' && ch <= 'Z') {
                ch = (char) ((ch - 65 + 13) % 26 + 65);
                sb.append(ch);

            }
            else if(ch >= 'a' && ch <= 'z') {
                ch = (char) ((ch - 97 + 13) % 26 + 97);
                sb.append(ch);
            }
            else {
                sb.append(ch);
            }
        }

        System.out.println(sb);
    }
}
