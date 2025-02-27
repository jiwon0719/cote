import java.util.*;

public class b_11724_연결요소의개수_그래프BFS {

   static int N, M;
   static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
   static boolean[] isvisited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for(int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }
        isvisited = new boolean[N+1];

        // intput
        for(int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

//        for(int i = 0; i <= N; i++) {
//            System.out.println(i+"번 : " + graph.get(i).toString());
//        }

        int ans = 0;
        for(int i = 1; i <= N; i++) {
            if(!isvisited[i]) {
                bfs(graph, i, isvisited);
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static void bfs(ArrayList<ArrayList<Integer>> graph, int start, boolean[] isvisited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        isvisited[start] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 노드와 연결된 노드들을 큐에 추가하며 그래프 탐색
            for(int next : graph.get(current)) {
                if(!isvisited[next]) { // 방문하지 않았으면
                    queue.add(next);
                    isvisited[next] = true;
                }
            }
        }
    }
}
