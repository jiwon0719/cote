import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 전체 사람의 수

        // 그래프 초기화
        graph = new List[n+1];
        for(int i = 1; i <= n; i++) {
                graph[i] = new LinkedList<>();
        }

        // input
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target1 = Integer.parseInt(st.nextToken());
        int target2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine()); // 관계 개수

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph[parent].add(child);
            graph[child].add(parent);
        }

        System.out.println(bfs(target1, target2));
    }

    public static int bfs(int target1, int target2) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n+1];
        queue.add(new int[] {target1, 0});
        visited[target1] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int current =  curr[0];
            int dist =  curr[1];

            if(current == target2) return dist;

            for(int next : graph[current]) {
                if(visited[next]) continue;
                visited[next] = true;
                queue.add(new int[] {next, dist + 1});
            }
        }

        return -1;
    }
}
