import java.util.Scanner;

public class b_11659_구간합구하기4_dp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] num = new int[N+1];
        num[0] = 0;
        for(int i = 1; i <= N; i++) {
            num[i] = num[i-1] + sc.nextInt(); // 숫자들의 누적합 담아두기
        }
        for(int t = 1; t <= M; t++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            System.out.println(num[end] - num[start - 1]);
        }
    }
}
