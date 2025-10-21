import java.io.*;
import java.util.*;

public class Main {
    static long n, answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Long.parseLong(br.readLine());
        binarySearch(n);
        System.out.println(answer);
    }

    static void binarySearch(long key) {
        long left = 0;
        long right = key;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (key <= Math.pow(mid, 2)){
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }
}