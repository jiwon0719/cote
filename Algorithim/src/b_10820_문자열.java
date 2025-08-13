import java.io.*;
import java.util.*;

public class b_10820_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = br.readLine();
            if(str == null) break;

            /**
             * This is String
             * SPACE    1    SPACE
             *  S a M p L e I n P u T
             * 0L1A2S3T4L5I6N7E8
             */
            int[] answer = new int[4]; // 소문자, 대문자, 숫자, 공백
            for(char ch : str.toCharArray()) {
                if(ch == ' ') answer[3]++;
                else if(ch >= 'A' && ch <= 'Z') answer[1]++;
                else if(ch >= 'a' && ch <= 'z') answer[0]++;
                else if(ch >= '0' && ch <= '9') answer[2]++;
            }

            for(int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        br.close();
    }
}
