import java.util.Arrays;
import java.util.Scanner;

/**
 * 1 <= N <= 1,000,000
 * -10^9 <= X <= 10^9
 *
 * 이분탐색
 * 완탐 안되는 이유 : 시간복잡도(N^N) = 1,000,000 * 1,000,000 = 1,000,000,000,000
 *
 * 0) 좌표 (2 4 -10 4 -9) 2 3 0 3 1
 * 1) 정렬된 자표 새로 생성 (-10 -9 2 4 4)
 * 2) target값이 처음 나오는 인덱스 값 찾기 = 인덱스 값이 개수가 됨
 * 3) 인덱스 값 차례로 출력
 *
 * 주의
 * 중복되는 숫자를 처리해야함
 *
 */
public class b_18870_좌표압축_이분탐색 {

    static int N;
    static int[] arr, sortedArr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        arr = new int[N];
        sortedArr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sortedArr[i] = arr[i];
        }

        // 정렬
        Arrays.sort(sortedArr);

        // 중복 제거
        sortedArr = Arrays.stream(sortedArr).distinct().toArray();
//        System.out.println(Arrays.toString(sortedArr));

        // 이분탐색
        for(int i = 0; i < N; i++) {
            sb.append(lowerBound(sortedArr, arr[i]) + " ");
        }

        // 출력
        System.out.print(sb);
    }

    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while(left < right) {
            int mid = left + (right - left) / 2;

            // mid가 내가 찾는 값보다 크다면? 오른쪽 볼 필요 없음. 왼쪽만 봐
            // mid가 내가 찾는 값보다 작다면? 왼쪽 볼 필요 없음. 오른쪽만 봐
            // mid가 내가 찾는 값이라면? 오른쪽 볼 필요 없음. 왼쪽만 봐
            if(arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
