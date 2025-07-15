import java.io.*;
import java.util.*;

public class b_14719_빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];

        st = new StringTokenizer(br.readLine());
        for(int c = 0; c < C; c++) {
            int count = Integer.parseInt(st.nextToken());
            for(int r = R - 1; r >= 0; r--) {
                if(count > 0) {
                    map[r][c] = 1;
                    count--;
                }
            }
        }

//        for(int r = 0; r < R; r++) {
//            for(int c = 0; c < C; c++) {
//                System.out.print(map[r][c] + " ");
//            }
//            System.out.println();
//        }

        int answer = 0;
        for(int r = R - 1; r >= 0; r--) {
            List<Integer> list = new ArrayList<>();
            for(int c = 0; c < C; c++) {
                 if(map[r][c] == 1) list.add(c);
            }

            for(int i = 0; i < list.size() - 1; i++) {
                int now = list.get(i);
                int next = list.get(i + 1);
                answer += (next - now) - 1;
            }
        }

        System.out.println(answer);
    }
}
