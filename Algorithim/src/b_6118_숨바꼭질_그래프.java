import java.util.*;

/**
 * 첫 번째는 숨어야 하는 헛간 번호를(만약 거리가 같은 헛간이 여러개면 가장 작은 헛간 번호를 출력한다),
 * 두 번째는 그 헛간까지의 거리를,
 * 세 번째는 그 헛간과 같은 거리를 갖는 헛간의 개수를 출력해야한다.
 *
 * 1번 헛간으로부터 가장 먼 거리의 헛간 번호, 거리, 같은 거리 가진 헛간 개수 출력
 */

public class b_6118_숨바꼭질_그래프 {

    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 헛간(정점) 개수
        M = sc.nextInt(); // 간선 개수
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // input
        for(int i = 0;  i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        bfs(1);
    }

    private static void bfs(int start) {
        boolean[] isvisited = new boolean[N+1];
        Queue<int[]> queue = new LinkedList<>();
        int maxDist = 0, hideNum = Integer.MAX_VALUE, sameDistCount = 0;

        queue.add(new int[]{start, 0});
        isvisited[start] = true;

        while(!queue.isEmpty()) {
            int current[] = queue.poll();
            int node = current[0];
            int dist = current[1];

            // 더 긴 거리 발견
            if(dist > maxDist) {
                maxDist = dist;
                hideNum = node;
                sameDistCount = 1;
            }
            // 같은 거리인 경우
            else if (dist == maxDist) {
                hideNum = Math.min(hideNum, node);
                sameDistCount++;
            }

            for(int next : graph.get(node)) {
                if(!isvisited[next]) { // 방문하지 않은 곳이면
                    queue.add(new int[] {next, dist+1});
                    isvisited[next] = true;
                }
            }
        }
        System.out.println(hideNum+" "+maxDist+" "+sameDistCount);
    }
}
