import java.io.*;
import java.util.*;

public class b_11656_접미사배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = new String[str.length()];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = str.substring(i, str.length());
        }

        Arrays.sort(arr);

        for(String s : arr) {
            System.out.println(s);
        }
    }
}
