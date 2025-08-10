import java.util.*;
import java.io.*;

public class ㅋㅋ {

    static int N, K, ans;
    static int[] cards, sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        cards = new int[N];
        sel = new int[3];

        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        comb(0, 0);

        System.out.println(ans);
    }

    public static void comb(int idx, int cnt) {
        if(cnt == 3) {
            int count = 0;
            for(int i = 0; i < 3; i++) {
                count += sel[i];
            }
            if(count <= K) ans = Math.max(ans, count);
            return;
        }

        if(idx >= N) return;

        sel[cnt] = cards[idx];
        comb(idx + 1, cnt + 1);
        comb(idx + 1, cnt);
    }
}
