import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class b_13305_주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        BigInteger[] roads = new BigInteger[N-1];
        BigInteger[] oils = new BigInteger[N];

        for(int i = 0; i < N - 1; i++) {
            roads[i] = new BigInteger(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            oils[i] = new BigInteger(st.nextToken());
        }

        BigInteger minOilPrice = oils[0];
        BigInteger answer = minOilPrice.multiply(roads[0]);

        for(int i = 1; i <= N - 2; i++) {
            if(minOilPrice.compareTo(oils[i]) > 0) {
                minOilPrice = oils[i];
            }

            answer = answer.add((minOilPrice.multiply(roads[i])));
        }

        System.out.println(answer);
    }
}
