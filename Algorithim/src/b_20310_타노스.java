import java.io.*;
import java.util.*;

public class b_20310_타노스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int count0 = 0;
        int count1 = 0;
        for(char ch : S.toCharArray()) {
            if(ch == '0') count0++;
            else count1++;
        }

        StringBuilder result = new StringBuilder();
        int remove0 = count0 / 2;
        int remove1 = count1 / 2;

        // 앞에서부터 1을 제거 (뒤에 1이 남도록)
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '1' && remove1 > 0) {
                remove1--;
                continue;
            }
            result.append(S.charAt(i));
        }

        // 뒤에서부터 0을 제거 (앞에 0이 남도록)
        StringBuilder finalResult = new StringBuilder();
        String temp = result.toString();
        for(int i = temp.length() - 1; i >= 0; i--) {
            if(temp.charAt(i) == '0' && remove0 > 0) {
                remove0--;
                continue;
            }
            finalResult.append(temp.charAt(i));
        }

        System.out.println(finalResult.reverse().toString());
    }
}
