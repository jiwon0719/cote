import java.util.*;

public class b_2660_회장뽑기_플로이드워셜 {
    private static int MAX_NUM = 99999;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 1 <= N <= 50
        int[][] graph = new int[N+1][N+1];

        // 초기화
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= N; j++) {
                graph[i][j] = MAX_NUM;
            }
        }
        for(int i = 0; i <= N; i++) {
            graph[i][i] = 0;
        }

        // input
        while(true) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            if(start == -1 && end == -1) break;

            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        ///////////////출력///////////////
//        for(int i = 0; i <= N; i++) {
//            for(int j = 0; j <= N; j++) {
//                System.out.print(graph[i][j]+" ");
//            }
//            System.out.println();
//        }



        // 플로이드 워셜
        for(int k = 0; k <= N; k++) {
            for(int i = 0; i <= N; i++) {
                for(int j = 0;j <= N; j++) {
                    if(graph[i][k] != MAX_NUM && graph[k][j] != MAX_NUM) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        // 번호 매기기
        int minGrade = Integer.MAX_VALUE; // 회장 후보 점수
        int candidateCnt = 0; // 회장 후보의 수
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            int grade = 0;
            for(int j = 1; j <= N; j++) {
                if(graph[i][j] != MAX_NUM && grade < graph[i][j]) {
                    grade = graph[i][j];
                }
            }

            if(minGrade == grade) {
                candidateCnt++;
                sb.append(i+" ");
            }
            if(minGrade > grade) {
                minGrade = grade;
                candidateCnt = 1;
                sb.setLength(0);
                sb.append(i+" ");

            }
        }


        System.out.println(minGrade + " " + candidateCnt);
        System.out.println(sb);

    }
}
