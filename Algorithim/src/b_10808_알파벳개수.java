import java.io.*;
import java.util.*;

public class b_10808_알파벳개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] alphabet = new int[26];

        for(char ch : str.toCharArray()) {
            alphabet[ch - 'a']++;
        }

        for(int i : alphabet) {
            System.out.print(i + " ");
        }
    }
}
