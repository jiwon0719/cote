import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] ascDP = new int[N]; // 증가하는 부분 수열
        int[] desDP = new int[N]; // 감소하는 부분 수열

        Arrays.fill(ascDP, 1);
        Arrays.fill(desDP, 1);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) ascDP[i] = Math.max(ascDP[i], ascDP[j] + 1);
            }
        }

        for(int i = N-1; i >= 0; i--) {
            for(int j = i+1; j < N; j++) {
                if(arr[i] > arr[j]) desDP[i] = Math.max(desDP[i], desDP[j] + 1);
            }
        }

        int answer = 0;
        for(int i = 0; i < N; i++) {
            int count = ascDP[i] + desDP[i] - 1;
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
