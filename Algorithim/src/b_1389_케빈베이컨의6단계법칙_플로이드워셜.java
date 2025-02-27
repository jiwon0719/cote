import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class b_1389_케빈베이컨의6단계법칙_플로이드워셜 {

    static int N, M;
    static int[][] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N+1][N+1];

        // 초기화
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= N; j++) {
                graph[i][j] = 99999;
            }
        }
        for(int i = 0; i <= N; i++) {
            graph[i][i] = 0;
        }

        // input
        for(int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            if(graph[start][end] != 1) graph[start][end] = 1;
            if(graph[end][start] != 1) graph[end][start] = 1;
        }

        // 플로이드워셜 알고리즘
        for(int k = 0; k <= N; k++) {
            for(int i = 0; i <= N; i++) {
                for(int j = 0; j <= N; j++) {
                    if(graph[i][k] != 99999 && graph[k][j] != 99999) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        // 단계 합 가장 작은 숫자와 인덱스 찾아서 저장
        int minCnt = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for(int i = 1;i <= N; i++) {
            int cnt = 0;
            for(int j = 1; j <= N; j++) {
                cnt += graph[i][j];
            }

            if(minCnt > cnt) { // 가장 작은 숫자 찾으면 저장
                minCnt = cnt;
                ans = i;
            }
        }
        System.out.println(ans);
    }
}
