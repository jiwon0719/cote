import java.util.Arrays;
import java.util.Scanner;

/**
 * 집합 A에는 속하면서 집합 B에는 속하지 않는 모든 원소 구하기
 *
 * 집합에 속하는 원소 값은 21억을 넘지 않는 자연수! == int 사용
 * 집합에 속하는 원소 개수는 최대 500,000를 넘지 않음 == 완탐 안됨, 이분탐색
 * 집합에 속하는 원소 값은 중복되지 않음 == 경계분석 X, 값 찾기O
 *
 * A원소가 B에 있는지 이분탐색으로 확인
 * 있으면 다음원소 탐색, 없으면 StringBuilder에 추가
 * StringBuilder에 길이가 0이면 0출력
 */
public class b_1822_차집합_이분탐색 {

    static int a, b;
    static int[] arrA, arrB;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        a = sc.nextInt();
        b = sc.nextInt();
        arrA = new int[a];
        arrB = new int[b];

        for(int i = 0; i < a; i++) {
            arrA[i] = sc.nextInt();
        }
        for(int i = 0; i < b; i++) {
            arrB[i] = sc.nextInt();
        }

        // 정렬
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        // 이분탐색
        for(int i = 0; i < a; i++) {
            int ans = Bsearch(arrB, arrA[i]);
            if(ans != 0) { // 집합B에 없는 숫자
                cnt++;
                sb.append(ans + " ");
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
    }

    private static int Bsearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(arr[mid] > target) {
                right = mid - 1;
            } else if(arr[mid] < target) {
                left = mid + 1;
            } else {
                return 0; // 찾으면 target을 출력하면 안됨
            }
        }

        return target; // 못찾았어. 그럼 target값 출력
    }
}
