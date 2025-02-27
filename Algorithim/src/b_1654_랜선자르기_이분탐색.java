import java.util.Scanner;

public class b_1654_랜선자르기_이분탐색 {

    static int K, N; // K :가지고 있는 랜선 개수, N : 원하는 랜선 개수
    static long [] lens; // 랜선의 길이는 1 ~ 2^31 - 1
    static long ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();
        ans = 0;
        lens = new long[K];

        long right = 0;

        for(int i = 0 ; i < K; i++) {
            lens[i] = sc.nextInt();
            if(right < lens[i]) right = lens[i];
        }

        long left = 1;
        long mid;

        while(left <= right) {
            mid = left + (right - left) / 2;
            if(mid == 0) break; // 0일때는 나눌 수 없음 런타임 에러(by zero)
            int lenCnt = BSearch(mid);
            if(lenCnt >= N) { // 충분하네? 랜선 최대 길이를 더 늘려볼까?
                ans = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static int BSearch(long mid) {
        int lenCnt = 0;
        for(int i = 0; i < K; i++) {
            lenCnt += lens[i] / mid; // 몫
        }
        return lenCnt;
    }
}
