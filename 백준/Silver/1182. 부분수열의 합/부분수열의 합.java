import java.io.*;
import java.util.*;

public class Main {

    static int N, S;
    static int[] arr;
    static boolean[] isvisited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        isvisited = new boolean[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        powerSet(0,0);
        if(S== 0) count--;

        System.out.println(count);

    }

    public static void powerSet(int cnt, int sum) {
        if(cnt == N) {
            if(sum == S) count++;
            return;
        }

        powerSet(cnt + 1, sum); // 원소 선택 안함

        powerSet(cnt + 1, sum + arr[cnt]); // 원소 선택함
    }
}
