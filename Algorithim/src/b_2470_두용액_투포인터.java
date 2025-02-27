import java.util.Arrays;
import java.util.Scanner;

public class b_2470_두용액_투포인터 {

    static int N; // 2 <= N <= 100,000
    static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        // 투 포인터 알고리즘 사용을 위한 정렬
        Arrays.sort(nums);

        // 투 포인터 알고리즘
        int left = 0;
        int right = N-1;
        int target = Integer.MAX_VALUE; // 0에 가장 가까운 값을 찾아야 함.
        int sol1 = 0;
        int sol2 = 0;

        while(left < right) { // 서로 다른 두 용액을 선택해야 하므로 left == right인 경우는 고려하지 않음
            int sum = Math.abs(nums[left] + nums[right]); // 두 용액값 합의 절대값 확인

            if(sum < target) { // 현재 저장되어있는 타겟값보다 0에 가까운 값을 찾은경우
                target = sum;
                sol1 = nums[left];
                sol2 = nums[right];

                if(sum == 0) break;
            } else {
                if(Math.abs(nums[left] ) < Math.abs(nums[right])) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(sol1 + " " + sol2);
    }
}
