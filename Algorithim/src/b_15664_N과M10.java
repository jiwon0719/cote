import java.util.*;
import java.io.*;

public class b_15664_N과M10 {

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

        // 조합
        // input 값 중복 될 수 있음
        comb(0, 0);
        bw.flush();
        bw.close();
    }

    private static void comb(int depth, int start) throws IOException {
        if(depth == M) {
            for(int n : arr) {
                bw.write(String.valueOf(n) + " ");
            }
            bw.newLine();
            return;
        }

        int before = 0;
        for(int i = start; i < N; i++) {
            if(before == num[i]) continue;
            arr[depth] = num[i];
            before = num[i];
            comb(depth + 1, i + 1);
        }
    }
}
