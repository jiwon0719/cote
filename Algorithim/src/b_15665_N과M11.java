import java.io.*;
import java.util.*;

public class b_15665_N과M11 {

    static int N, M;
    static int[] arr, num;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        // 중복순열
        // 중복 input값 있을 수 있음
        perm(0);
        bw.flush();
        bw.close();
    }

    private static void perm(int depth) throws IOException {
        if(depth == M) {
            for(int n : arr) {
                bw.write(String.valueOf(n) + " ");
            }
            bw.newLine();
            return;
        }

        int before = 0;
        for(int i = 0; i < N; i++) {
            if(before == num[i]) continue;
            arr[depth] = num[i];
            before = num[i];
            perm(depth + 1);
        }
    }
}
