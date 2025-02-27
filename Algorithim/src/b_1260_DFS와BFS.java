import java.util.*;

public class b_1260_DFS와BFS {

    static int N, M, V;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // input
        for(int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        // sort(작은 정점부터 방문하기 위함)
        for(int i = 0; i <= N; i++) {
            ArrayList<Integer> arr = graph.get(i);
            Collections.sort(arr);
            graph.add(arr);
        }

        // 그래프 확인
//        for(int i = 0; i <= N; i++) {
//            System.out.println(i+"번 : " + graph.get(i).toString());
//        }

        // DFS
        boolean[] isvisited = new boolean[N+1];
        StringBuilder sb = new StringBuilder();
        sb.append(V+" ");
        dfs(graph, V, sb, isvisited);
        System.out.println(sb);

        // BFS
        bfs(graph, V);

    }

    private static void bfs(ArrayList<ArrayList<Integer>> graph, int start) {
        StringBuffer sb = new StringBuffer();
        boolean[] isvisited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        isvisited[start] = true;
        sb.append(V + " ");

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int next : graph.get(current)) {
                if(!isvisited[next]) { // 방문 처음할 떄
                    queue.add(next);
                    isvisited[next] = true;
                    sb.append(next + " ");
                }
            }

        }
        System.out.println(sb);
    }

    // DFS
    private static void dfs(ArrayList<ArrayList<Integer>> graph, int start, StringBuilder sb, boolean[] isvisited) {
        isvisited[start] = true;

        for(int next : graph.get(start)) {
            if(!isvisited[next]) {
                sb.append(next+ " ");
                dfs(graph, next, sb, isvisited);
            }
        }
    }
}


