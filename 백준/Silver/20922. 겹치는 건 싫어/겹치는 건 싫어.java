import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int maxLength = 0;
        int[] count = new int[100001];

        for(int right = 0; right < N; right++) {
            // 오른쪽 포인터 숫자를 윈도우에 추가
            count[nums[right]]++;

            // 조건 위반 시, 왼쪽 포인터를 조정
            while(count[nums[right]] > K) {
                count[nums[left]]--;
                left++;
            }

            // 윈도우 최대 크기 저장
            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);
    }
}
