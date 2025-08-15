import java.io.*;
import java.util.*;

public class b_10451_순열싸이클 {

    static int N, ans;
    static ArrayList<Integer>[] graph;
    static boolean[] isvisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            graph = new ArrayList[N+1];
            for(int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                int num = Integer.parseInt(st.nextToken());
                graph[i].add(num);
                graph[num].add(i); // 양방향 그래프
            }

            ans = 0;
            isvisit = new boolean[N+1];
            for(int i = 1; i <= N; i++) {
                if(!isvisit[i]) { // 방문하지 않은 정점을 마주치면 그래프 순회 시작
                    ans++;
                    dfs(i);
                }
            }

            System.out.println(ans);
        }
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
