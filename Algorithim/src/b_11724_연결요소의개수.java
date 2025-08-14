import java.io.*;
import java.util.*;

public class b_11724_연결요소의개수 {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] isvisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        isvisit = new boolean[N+1];
        int ans = 0;
        for(int i = 1; i <= N; i++) {
            if(!isvisit[i]) {
                ans++;
                dfs(i);
            }
        }

        System.out.println(ans);
    }

    public static void dfs(int v) {
        if(isvisit[v]) return;

        isvisit[v] = true;

        for(int next : graph[v]) {
            if(!isvisit[next]) {
                dfs(next);
            }
        }
    }
}