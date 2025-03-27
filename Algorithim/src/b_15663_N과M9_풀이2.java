import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class b_15663_N과M9_풀이2 {

    static int N, M;
    static int[] arr;
    static int[] num;
    static boolean[] isvisited;
    static LinkedHashSet<String> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        num = new int[N];
        isvisited = new boolean[N];
        ans = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        // 순열
        // 중복 입력있을수 있음
        // 중복 수열 출력 X
        dfs(0);

        ans.forEach(System.out::println);
    }

    private static void dfs(int depth) throws IOException {
        if(depth == M) {
            StringBuilder sb = new StringBuilder();
            for(int n : arr) {
                sb.append(n).append(" ");
            }
            ans.add(sb.toString());
            return;
        }

        for(int i = 0; i < N; i++) {
            if(isvisited[i]) continue;
            isvisited[i] = true;
            arr[depth] = num[i];
            dfs(depth + 1);
            isvisited[i] = false;
        }
    }
}
