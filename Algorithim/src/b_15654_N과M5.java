import java.io.*;
import java.util.*;

public class b_15654_N과M5 {

    static int N, M;
    static int[] arr;
    static boolean[] isvisited;
    static int[] num;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        isvisited = new boolean[N];
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 사전 증가하는 수로 만들기 위해 정렬
        Arrays.sort(num);

        // 순열
        // 자연수 input 값 저장하는거만 차이 있음
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

        for(int i = 0; i < N; i++) {
            if(isvisited[i]) continue;
            isvisited[i] = true;
            arr[depth] = num[i];
            perm(depth + 1);
            isvisited[i] = false;
        }
    }
}
