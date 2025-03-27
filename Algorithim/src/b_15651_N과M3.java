import java.io.*;
import java.util.*;

public class b_15651_N과M3 {

    static int N, M;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        perm(0);
        bw.flush();
        bw.close();
    }

    public static void perm(int depth) throws IOException {
        if(depth == M) {
            for(int num : arr) {
                bw.write(String.valueOf(num) + " ");
            }
            bw.newLine();
            return;
        }

        for(int i = 1 ; i <= N; i++) {
            arr[depth] = i;
            perm(depth + 1);
        }
    }
}
