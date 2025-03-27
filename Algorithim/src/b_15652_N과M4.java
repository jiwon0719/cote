import java.io.*;
import java.util.*;

public class b_15652_N과M4 {

    static int N, M;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        comb(0, 1);
        bw.flush();
        bw.close();
    }

    private static void comb(int depth, int start) throws IOException {
        if(depth == M) {
            for(int num : arr) {
                bw.write(String.valueOf(num) + " ");
            }
            bw.newLine();
            return;
        }

        for(int i = start; i <= N; i++) {
            arr[depth] = i;
            comb(depth + 1, i); // 숫자 중복이 가능하기에
        }
    }
}
