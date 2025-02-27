import java.util.Arrays;
import java.util.Scanner;

public class b_10816_숫자카드2_이분탐색 {

    static int N, M;
    static int[] cards;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cards = new int[N];
        for(int i = 0; i < N; i++) {
            cards[i] = sc.nextInt();
        }

        // 정렬
        Arrays.sort(cards);

        // 가지고 있는 카드 개수 찾기
        // lowerBound : 찾으려는 값이 처음 나타나는 인덱스 반환
        // upperBound : 찾으려는 값보다 큰 값이 처음 나타나는 인덱스 반환
        // upperBound - lowerBound = 가지고 있는 카드 개수
        M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int num = sc.nextInt();
            int cnt = upperBound(cards, num) - lowerBound(cards, num);
            System.out.print(cnt + " ");
        }
    }

    private static int upperBound(int[] cards, int num) {
        int left = 0;
        int right = cards.length; // 위치를 찾을때는 배열 길이로 right값 주기. 왜? 내가 찾으려는 값보다 큰 값이 없을수도 있으니까

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(cards[mid] > num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int lowerBound(int[] cards, int num) {
        int left = 0;
        int right = cards.length;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(cards[mid] >= num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
