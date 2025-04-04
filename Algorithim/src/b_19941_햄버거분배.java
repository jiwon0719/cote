import java.io.*;
import java.util.StringTokenizer;

public class b_19941_햄버거분배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        boolean[] burger = new boolean[N];

        int cnt = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'P') { // 사람이면
                // 햄버거 먹을 수 있는 범위 구하기
                int start = Math.max(0, i - K);
                int end = Math.min(N - 1, i + K); // 이거 맞나 ?

                for(int j = start; j <= end; j++) {
                    if(str.charAt(j) == 'H' && !burger[j]) { // 햄버거이고 안먹었으면
                        burger[j] = true;
                        cnt++;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);

    }
}
