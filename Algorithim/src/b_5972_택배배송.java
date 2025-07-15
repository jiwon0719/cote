import java.io.*;
import java.util.*;

public class b_5972_택배배송 {
    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    static int N, M;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];

        // 초기화
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        // input
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, cost));
            graph[b].add(new Node(a, cost));
        }

        // 다익스트라 알고리즘
        dijkstra(1);

        System.out.println(dist[N]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost); // 오름차순

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();

            if(!visited[current.v]) {
                visited[current.v] = true;
            }

            for(Node next : graph[current.v]) {
                if(!visited[next.v] && dist[next.v] > current.cost + next.cost) {
                    dist[next.v] = current.cost + next.cost;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}
