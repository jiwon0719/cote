import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        BigInteger num = new BigInteger(str, 2); // 2진수로 읽어서 > 10진수로 저장

        System.out.println(num.toString(8)); // 10진수 값을 >  n진수 문자열로 변환
    }
}

