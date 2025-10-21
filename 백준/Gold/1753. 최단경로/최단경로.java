import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static int V, E, K;
    static List<Node>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        list = new ArrayList[V + 1]; // 구현체 ArrayList 맨날 헷갈림
        dist = new int[V + 1];

        for(int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++) {
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[V + 1];
        queue.offer(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int cur = curNode.end;

            if(check[cur] == true) continue;
            check[cur] = true;

            for(Node node : list[cur]){
                if(dist[node.end] > dist[cur] + node.weight){
                    dist[node.end] = dist[cur] + node.weight;
                    queue.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}
