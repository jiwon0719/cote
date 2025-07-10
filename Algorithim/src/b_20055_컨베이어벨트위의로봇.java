import java.io.*;
import java.util.*;

public class b_20055_컨베이어벨트위의로봇 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] robot = new int[N];
        int[] belt = new int[2 * N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int step = 0;
        while(true) {
            step++;
            // 1. 벨트가 로봇과 함께 회전한다.
            int[] tmp = Arrays.copyOf(belt, 2 * N); // 깊은 복사? 얕은 복사?
            for(int i = 1; i < 2 * N; i++) {
                belt[i] = tmp[i-1];
            }
            belt[0] = tmp[(2 * N) - 1];

            int[] tmp2 = Arrays.copyOf(robot, N);
            for(int i = 0; i < N - 1; i++) {
                robot[i + 1] = tmp2[i];
            }
            robot[0] = 0; // 항상 2N에 있던 로봇이 올라올텐데, 2N에는 로봇이 있을 수 없음

            // 1-1. 로봇이 내리는 위치이면 즉시 내린다.
            if(robot[N-1] != 0) {
                robot[N-1] = 0;
            }

            // 2. 가장 벨트에 먼저 올라간 로봇부터 이동한다. 이동하지 못한다면 넘긴다.
                for(int i = N-2; i >= 0; i--) {
                    // 3. 이동하기 위해서는 이동하려는 칸에 로봇이 없어야 하고, 그 칸의 내구도가 1이상이어야 한다.
                    if(robot[i] != 0 && robot[i+1] == 0 && belt[i+1] > 0) {
                        int tmp3 = robot[i];
                        robot[i+1] = tmp3;
                        robot[i] = 0;
                        belt[i+1]--;
                    }
                }

            // 3-1. 로봇이 내리는 위치이면 즉시 내린다.
            if(robot[N-1] != 0) {
                robot[N-1] = 0;
            }

            // 4. 올리는 위치에 있는 칸의 내구도가 0이 아니면 새로운 로봇을 올린다.
            if(belt[0] != 0) {
                robot[0] = step;
                belt[0]--;
            }

            // 5. 내구도가 0인 칸의 개수가 k개 이상이면 종료한다.
            int zeroCount = 0;
            for(int i = 0; i < 2 * N; i++) {
                if(belt[i] == 0) {zeroCount++;}
            }

            if(zeroCount >= K) {
                System.out.println(step);
                return;
            }
        }
    }
}
