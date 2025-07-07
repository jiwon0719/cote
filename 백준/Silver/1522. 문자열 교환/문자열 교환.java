import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] arr = str.toCharArray();

        // a 개수 세기
        int aCnt = 0;
        for(char c : arr) {
            if(c == 'a') aCnt++;
        }

        // 원형 연결을 위해 문자열 두 배로 만들기
        String doubled = str + str;
        char[] arr2 = doubled.toCharArray();

        // a 개수 만큼 잘라서 b개수 확인하기
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < str.length(); i++) {
            int sum = 0;
            for(int j = i; j < i + aCnt; j++) {
                if(arr2[j] == 'b') sum++;
            }
            answer = Math.min(answer, sum);
        }

        System.out.println(answer);
    }
}
