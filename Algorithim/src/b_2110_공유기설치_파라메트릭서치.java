import java.util.Arrays;
import java.util.Scanner;

public class b_2110_공유기설치_파라메트릭서치 {

    static int N, C;
    static int[] houses;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();
        houses = new int[N];

        for(int i = 0; i < N; i++) {
            houses[i] = sc.nextInt();
        }

        // 좌표 정렬
        Arrays.sort(houses);
//        System.out.println(Arrays.toString(houses));

        int maxDist = houses[N-1]; // 공유기 간 거리 최댓값

        int left = 0;
        int right = houses[N-1];

        while(left <= right) { // 몰라
            int cnt = 1; // 공유기 설치한 개수
            int mid = left + (right - left) / 2;
            int lastInstall = 0;
            for(int i = 1; i < N; i++) {
                int dist = houses[i] - houses[lastInstall];

                if(dist >= mid) {  // 공유기 설치가 가능하면
                    cnt++;
                    lastInstall = i;
                }
            }

            if(cnt >= C) {
                maxDist = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(maxDist);
    }
}
