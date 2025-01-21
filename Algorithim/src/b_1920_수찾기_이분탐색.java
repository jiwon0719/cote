import java.util.Arrays;
import java.util.Scanner;

public class b_1920_수찾기_이분탐색 {

    static int N, M;
    static int[] NArray, MArray;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        NArray = new int[N];
        for(int i = 0; i < N; i++) {
            NArray[i] = sc.nextInt();
        }
        M = sc.nextInt();
        MArray = new int[M];
        for(int i = 0; i < M;i++) {
            MArray[i] = sc.nextInt();
        }

        Arrays.sort(NArray);
//        Arrays.sort(MArray);

//        System.out.println(Arrays.toString(NArray));
//        System.out.println(Arrays.toString(MArray));

        for(int i = 0; i < M; i++) {
            System.out.println(BSearch(NArray, MArray[i]));
        }

    }

    private static int BSearch(int[] NArray, int m) {
        int left = 0;
        int right = NArray.length - 1;
        int mid;

        while(left <= right) {
            mid = (left + right) / 2;
            if(NArray[mid] < m) left = mid + 1;
            else if (NArray[mid] > m) right = mid - 1;
            else return 1;
        }
        return 0;
    }
}