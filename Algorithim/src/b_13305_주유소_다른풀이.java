import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class b_13305_주유소_다른풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Long[] roads = new Long[N-1];
        Long[] oils = new Long[N];

        for(int i = 0; i < N - 1; i++) {
            roads[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            oils[i] = Long.parseLong(st.nextToken());
        }

        Long minOilPrice = oils[0];
        Long answer = minOilPrice * roads[0];

        for(int i = 1; i <= N - 2; i++) {
            if(minOilPrice > oils[i]) {
                minOilPrice = oils[i];
            }

            answer += minOilPrice * roads[i];
        }

        System.out.println(answer);
    }
}
