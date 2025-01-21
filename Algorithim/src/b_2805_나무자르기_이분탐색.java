import java.util.Scanner;

public class b_2805_나무자르기_이분탐색 {

    static int N, M;
    static int[] tree;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        tree = new int[N];
        ans = 0;

        for(int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
        }

//        Arrays.sort(tree); // 이 문제에서는 높이의 차가 중요하므로 정렬 하는건 불필요한 로직 O(NlogM)

        int left = 0;
        int right = tree[0];
        for(int i = 0; i < N; i++) {
            if(right < tree[i]) right = tree[i];
        }

        while(left <= right) {
            int mid = left + (right - left) / 2; // 정수 오버플로우를 방지하며 mid 값 구하는 안정적인 방법
            long sum = action(mid); // 높이의 합이 21억을 넘어갈 수 있음

            if(sum >= M) { // 적어도 M미터의 나무는 가져가야 하니까 딱 떨어지면 좋지만, 넉넉히 가져갈때는 우선 mid값 저장해야함
                ans = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static long action(int h) {
        long sum = 0;

        for(int i = 0; i < N; i++) {
            int tmp = tree[i] - h;
            if(tmp > 0) sum += tmp;
        }
        return sum;
    }
}
