import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long sum ;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            nums = new int[N];
            for(int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            // 조합
            int[] arr = new int[2];
            sum = 0;
            comb(0, 0, arr);

            System.out.println(sum);
        }
    }

    public static void comb(int start, int idx, int[] arr) {
        if(idx == 2) {
            sum += gcd(nums[arr[0]], nums[arr[1]]);
            return;
        }

        for(int i = start; i < N; i++) {
            arr[idx] = i;  // 인덱스 저장!
            comb(i + 1, idx + 1, arr);
        }
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, (a % b));
    }
}


