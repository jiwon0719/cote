import java.io.*;
import java.util.*;

public class b_25757_임스와함께하는미니게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();


        int startNum = 0;
        if(game.equals("Y")) startNum = 1;
        else if(game.equals("F")) startNum = 2;
        else startNum = 3;

        Set<String> alreadyGamePerson = new HashSet<>();

        for(int i = 0; i < N; i++) {
            String personId = br.readLine();
            alreadyGamePerson.add(personId);
        }

        int ans = alreadyGamePerson.size() / startNum;

        System.out.println(ans);
    }
}