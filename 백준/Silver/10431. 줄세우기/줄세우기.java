import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken(); // testcase num
            int[] arr = new int[20];
            for(int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer> list = new ArrayList<>();
            // 인덱스 0번을 뽑는다.
            list.add(arr[0]);

            // 리스트안에 본인보다 큰 숫자가 몇개 잇는지 찾는다.
            // 1칸만큼 뒤로 간다.
            int answer = 0;
            for(int i = 1; i < 20; i++) {
                int current = arr[i];
                for(int a : list) {
                    if(a > current) answer++;
                }
                list.add(current);
            }






            System.out.println(t + " " + answer);
        }
    }
}
