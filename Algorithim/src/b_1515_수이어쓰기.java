import java.util.*;
import java.io.*;

public class b_1515_수이어쓰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int N = 1;
        int idx = 0;

        while(true) {
            String strN = String.valueOf(N);

            for(int i = 0; i < strN.length(); i++) {
                if(strN.charAt(i) == line.charAt(idx)) {
                    idx++;
                }

                if (idx == line.length()) {
                    System.out.println(N);
                    return;
                }
            }

            N++;
        }


    }
}
