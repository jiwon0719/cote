import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int[] numbers;
    static boolean[] isvisited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        numbers = new int[n];
        isvisited = new boolean[n];

        per(0);
    }

    public static void per(int cnt) {
        if(cnt == n) {
            for(int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < n; i++) {
            if(isvisited[i]) continue;
            numbers[cnt] = arr[i];
            isvisited[i] = true;
            per(cnt + 1);
            isvisited[i] = false;
        }
    }
}
