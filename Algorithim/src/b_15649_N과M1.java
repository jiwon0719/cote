import java.io.*;
import java.util.*;

public class b_15649_N과M1 {

    static int N, M;
    static boolean[] isvisited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isvisited = new boolean[N+1];
        arr = new int[M];

        // 백트래킹(DFS)을 통해 중복 없는 수열 구하기
        dfs(0);
    }

    public static void dfs(int depth) { // sidx : 뽑은 개수
        if(depth == M) {
            for(int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++) { // idx(숫자 == 인덱스)
            if(isvisited[i]) continue; // 만약 이미 뽑았다면 넘어간다
            arr[depth] = i;
            isvisited[i] = true;
            dfs(depth + 1);
            isvisited[i] = false;
        }
    }
}
