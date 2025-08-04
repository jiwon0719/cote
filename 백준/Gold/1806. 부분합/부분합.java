import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 연속된 수들의 부분합 중 > 가변길이 슬라이딩 윈도우
        // 그 합이 S 이상이 되는 것 중 > 누적합
        // 가장 짧은 것의 길이 return

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for(int right = 0; right < N; right++) {
            // 오른쪽 확장(항상)
            sum += nums[right];

            // 부분합이 조건을 만족하면 길이 줄여보기(min 구해야 하니까)
            while(sum >= S) {
                minLength = Math.min(minLength, right - left + 1);

                // 왼쪽 제거하고 축소
                sum -= nums[left];
                left++;
            }
        }

        if(minLength == Integer.MAX_VALUE) minLength = 0;
        System.out.println(minLength);
    }
}
