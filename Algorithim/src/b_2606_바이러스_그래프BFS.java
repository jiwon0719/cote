import java.util.*;

public class b_2606_바이러스_그래프BFS {

    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
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

        // 그래프 확인
//        for(int i = 0; i <= N; i++) {
//            System.out.println(graph.get(i).toString());
//        }

        System.out.println(bfs(1)); // 1번 컴퓨터부터 바이러스 시작
    }

    private static int bfs(int start) {
        int ans = 0;
        boolean[] isvisited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        isvisited[start] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int next : graph.get(current)) {
                if(!isvisited[next]) {
                    queue.add(next);
                    isvisited[next] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
