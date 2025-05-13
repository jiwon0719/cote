import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] num;
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

        // 순열
        // 자기자신 포함 가능한
        comb(0);
        bw.flush();
        bw.close();
    }

    private static void comb(int depth) throws IOException {
        if(depth == M) {
            for(int n : arr) {
                bw.write(String.valueOf(n) + " ");
            }
            bw.newLine();
            return;
        }

        for(int i = 0; i < N; i++) {
            arr[depth] = num[i];
            comb(depth + 1);
        }
    }
}
