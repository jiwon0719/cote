import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b_8979_올림픽 {

    private static class Node implements Comparable<Node> {
        int num;
        int gold;
        int silver;
        int bronze;
        int rank;

        public Node(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Node o) {
            if(this.gold != o.gold) {
                return o.gold - this.gold;
            } else if(this.silver != o.silver) {
                return o.silver - this.silver;
            } else {
                return o.bronze - this.bronze;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();
        Node nodeK = null;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            Node newNode = new Node(num, gold, silver, bronze);
            list.add(newNode);

            if(num == K) {
                nodeK = newNode;
            }
        }

        Collections.sort(list);

        list.get(0).rank = 1;

        for(int i = 1; i < N; i++) {
            Node node1 = list.get(i-1);
            Node node2 = list.get(i);

            if(node1.gold == node2.gold && node1.silver == node2.silver && node1.bronze == node2.bronze) {
                node2.rank = node1.rank;
            } else {
                node2.rank = i + 1; // 짜증
            }

            if(node1.num == K) {
                System.out.println(node1.rank);
                return;
            }

            if(node2.num == K) {
                System.out.println(node2.rank);
                return;
            }
        }
    }
}