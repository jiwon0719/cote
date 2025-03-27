import java.io.*;
import java.util.*;

public class b_15663_N과M9 {

    static int N, M;
    static int[] arr;
    static int[] num;
    static boolean[] isvisited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        num = new int[N];
        isvisited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        // 순열
        // 중복 입력있을수 있음
        // 중복 수열 출력 X
        dfs(0);
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth) throws IOException {
        if(depth == M) {
            for(int n : arr) {
                bw.write(String.valueOf(n) +" ");
            }
            bw.newLine();
            return;
        }

        int before = 0;
        for(int i = 0; i < N; i++) {
            if(isvisited[i] || before == num[i]) continue;

            isvisited[i] = true;
            arr[depth] = num[i];
            before = num[i];
            dfs(depth + 1);
            isvisited[i] = false;
        }
    }
}
