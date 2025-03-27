import java.io.*;
import java.util.*;

public class b_4659_비밀번호발음하기 {
    // 모음 하나를 반드시 포함
    // 모음이 3개 혹은 자음이 2개 연속 오면 안된다
    // 같은 글자가 연속적으로 2개 오면 안되지만, ee 와 oo는 허용
    // end면 테스트 종료
    // 20자 이상 문자열, 대문자 없음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String password = br.readLine();

            if(password.equals("end")) {
                return;
            }

            // 규칙검사
            boolean check = true;

            // 모음이 1개도 없다면 실패
            if(!password.contains("a") && !password.contains("e") && !password.contains("i")
                    && !password.contains("o") && !password.contains("u")) {
                check = false;
            }

            // 모음이 3개, 자음이 3개 연속 올 수 없음
            int moCnt = 0;
            int jaCnt = 0;
            for(int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);

                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    moCnt++;
                    jaCnt = 0;
                } else {
                    moCnt = 0;
                    jaCnt++;
                }

                if(moCnt >= 3 || jaCnt >= 3) {
                    check = false;
                }
            }

            // 같은 글자가 연속적으로 2개 오면 안되지만, ee 와 oo는 허용
            for(int i = 1; i < password.length(); i++) {
                char prev = password.charAt(i-1);
                char next = password.charAt(i);

                if(prev == next && prev != 'e' && prev != 'o') {
                    check = false;
                }
            }

            // 출력
            if(check) {
                System.out.println("<" + password + "> is acceptable.");
            } else {
                System.out.println("<" + password + "> is not acceptable.");
            }
        }
    }
}
