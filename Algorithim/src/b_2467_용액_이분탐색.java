import java.io.*;
import java.util.*;

public class b_2467_용액_이분탐색 {

    static int N;
    static int[] num;

    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       N = sc.nextInt();
       num = new int[N];

        for(int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

//        Arrays.sort(num);

        int left = 0;
        int right = N - 1;
        int bestSum = Integer.MAX_VALUE;
        int answer1 = 0, answer2 = 0;

        while (left < right) {
            int currentSum = num[left] + num[right];

            if (Math.abs(currentSum) < Math.abs(bestSum)) {
                bestSum = currentSum;
                answer1 = num[left];
                answer2 = num[right];
            }

            if (currentSum < 0) {
                left++;
            }
            else {
                right--;
            }
        }

        System.out.println(answer1 + " " + answer2);
    }
}