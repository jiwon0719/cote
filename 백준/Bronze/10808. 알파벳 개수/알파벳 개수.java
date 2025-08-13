import java.io.*;
import java.util.*;

public class Main {
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
