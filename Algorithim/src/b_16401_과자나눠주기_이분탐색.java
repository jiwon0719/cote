import java.util.Arrays;
import java.util.Scanner;

/**
 * 최대한 긴 과자, 동일한 과자 길이
 * M명의 조카, N개의 과자
 * 1 <= M <= 1,000,000
 * 1 <= N <= 1,000,000
 * 과자 길이는 10억이하 자연수
 *
 * 막대 과자 최대 길이
 * 모든 조카에게 같은 길이의 과자를 나눠줄 수 없다면 0 출력
 */
public class b_16401_과자나눠주기_이분탐색 {

    static int M, N;
    static int[] cookieLen;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        cookieLen = new int[N];

        int left = 1;
        int right = 0;
        int mid = 0;
        int ans = 0;
        for(int i = 0; i < N; i++) {
            cookieLen[i] = sc.nextInt();
            if(cookieLen[i] > right) right = cookieLen[i];
        }

        // 정렬 필요없음

        // 이분탐색
        while(left <= right) {
            mid = left + (right - left) / 2;  // 막대 길이
            int cnt = cntMethod(mid); // 모든 조카에게 나눠줄 수 있는지 계산
            if(cnt >= M) {
                ans = mid;
                left = mid + 1; // 과자를 모두 나눠줄 순 있음. 더 길게 과자 줄 수 있는지 확인해볼까?
            }
            else right = mid -1;
        }

        System.out.println(ans);
    }

    private static int cntMethod(int len) {
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            cnt += cookieLen[i] / len;
        }
        return cnt;
    }
}
