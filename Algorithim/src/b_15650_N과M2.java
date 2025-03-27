import java.io.*;
import java.util.*;

public class b_15650_N과M2 {

    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        // 백트래킹으로 중복 없는 수열을 구하되, 오름차순 정렬만 저장하기
        dfs(1, 0);
    }

    public static void dfs(int  num, int depth) {
        if(depth == M) {
            for(int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for(int i = num; i <= N; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
