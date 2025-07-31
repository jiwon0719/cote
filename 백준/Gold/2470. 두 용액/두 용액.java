import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터 사용을 위한 배열 정렬
        Arrays.sort(nums);

        int left = 0;
        int right = N - 1;
        int minSum = Integer.MAX_VALUE;
        int answer1 = 0, answer2 = 0;

        while(left < right) {
            int sum = nums[left] + nums[right];

            if(Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                answer1 = nums[left];
                answer2 = nums[right];
            }

            if(sum > 0) right--;
            else left++;
        }

        System.out.println(answer1 + " " + answer2);
    }
}
