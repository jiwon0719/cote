import java.io.*;
import java.util.*;

public class b_21921_블로그 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0, tmp;
        int period = 1;
        for(int i = 0; i < X; i++) {
            sum += arr[i];
        }

        tmp = sum;
        for(int i = X; i < N; i++) {
            tmp += arr[i] - arr[i-X];

            if(sum < tmp) {
                sum = tmp;
                period = 1;
            } else if (sum == tmp) {
                period++;
            }
        }

        if(sum == 0) System.out.println("SAD");
        else {
            System.out.println(sum);
            System.out.println(period);
        }

    }
}
