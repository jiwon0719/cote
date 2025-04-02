import java.io.*;
import java.util.*;

public class b_1205_등수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 리스트에 있는 점수 개수 <= P
        int grade = Integer.parseInt(st.nextToken()); // 태수 점수
        int P = Integer.parseInt(st.nextToken()); // 리스트에 올라갈 수 있는 점수 개수 <= 50

        // N이 0이면 무조건 태수가 1등임
        if(N == 0) {
            System.out.println(1);
            return;
        }

        int[] list = new int[P];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        // 리스트에 올라와있는 가장 작은 점수와 비교해보기
        // 리스트에 못 올라갈 경우 -1 출력
        int smallestGrade = list[N-1];
        if(grade <= smallestGrade && N == P) {
            System.out.println(-1);
            return;
        }

        // 리스트 점수랑 돌면서 랭킹 비교하기
        int rank = 1;
        for(int i = 0; i < P; i++) {
            int compareGrade = list[i];

            if(compareGrade > grade) {
                rank++;
            } else {
                System.out.println(rank);
                return;
            }

        }


    }
}
