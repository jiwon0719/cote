import java.io.*;
import java.util.*;

public class b_1260_DFS와BFS_2 {
    static int N, M, V;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        // 그래프 초기화
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            // 양방향 그래프
            graph[start].add(end);
            graph[end].add(start);
        }

        // 그래프 정렬(작은 숫자부터 방문하기 위함)
        for(int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        boolean[] isvisit = new boolean[N+1];
        StringBuilder sb = new StringBuilder();
        dfs(V, isvisit, sb);
        System.out.println(sb);

        bfs(V);
    }

    public static void dfs(int V, boolean[] isvisit, StringBuilder sb) {
        if(isvisit[V]) return; // 방문했다면 리턴

        isvisit[V] = true; // 방문안했으니 방문 시키고
        sb.append(V).append(" ");

        for(int next : graph[V]) { // 정점을 돌면서 방문하지 않았으면 dfs 재귀
            if(!isvisit[next]) {
                dfs(next, isvisit, sb);
            }
        }
    }

    public static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isvisit = new boolean[N+1];
        StringBuilder sb = new StringBuilder();

        queue.offer(V);
        isvisit[V] = true;
        sb.append(V).append(" ");

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int next : graph[current]) {
                if(isvisit[next]) continue;
                queue.offer(next);
                isvisit[next] = true;
                sb.append(next).append(" ");
            }
        }
        System.out.println(sb);
    }
}
