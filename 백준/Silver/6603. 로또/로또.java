import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int[] numbers;
    static int n;
    static int r = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            // 마지막 input값이면 끝
            if(n == 0) break;

            // input
            arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 조합 : n개 중 순서없이 r개를 선택
            numbers = new int[r];
            comb(0, 0);
            System.out.println();
        }
    }

    public static void comb(int start, int cnt) {
        if(cnt == r) {
            for(int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < n; i++) {
            numbers[cnt] = arr[i];
            comb(i + 1, cnt+1);
        }
    }
}
