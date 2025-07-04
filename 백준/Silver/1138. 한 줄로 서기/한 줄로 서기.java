import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] output = new int[N];
        for(int i = 1; i <= N; i++) {
            int key = i;
            int currentCnt = 0;
            int targetCnt = input[i];

            for(int j = 0; j < N; j++) { // output 배열에서 자리 찾아가기
                if(output[j] != 0) continue;

                // current == target 확인
                if(currentCnt == targetCnt) {
                    output[j] = key;
                    break;
                } else {
                    if(output[j] == 0) {
                      currentCnt++;
                    }
                }
            }
        }

        for(int n : output) {
            System.out.print(n + " ");
        }
    }
}
