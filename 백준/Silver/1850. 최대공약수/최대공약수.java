import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long a = Long.parseLong(st.nextToken());
        Long b = Long.parseLong(st.nextToken());

        Long gcdLen = gcd(a, b);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < gcdLen; i++) {
            sb.append(1);
        }
        
        System.out.println(sb);
    }

    public static Long gcd(Long a, Long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}

