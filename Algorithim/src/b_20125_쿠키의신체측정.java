import java.io.*;
import java.util.*;

public class b_20125_쿠키의신체측정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        List<int[]> cookies = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '*') {
                    cookies.add(new int[] {i, j});
                }
            }
        }

        // 머리
        int[] head = cookies.get(0);
        for (int[] point : cookies) {
            if (point[0] < head[0]) {
                head = point;
            }
        }

        // 심장
        int[] heart = new int[]{head[0] + 1, head[1]};

        int leftArm = 0;
        int rightArm = 0;
        int waist = 0;
        int leftLeg = 0;
        int rightLeg = 0;

        for (int j = heart[1] - 1; j >= 0; j--) {
            if (map[heart[0]][j] == '*') {
                leftArm++;
            } else {
                break;
            }
        }

        for (int j = heart[1] + 1; j < N; j++) {
            if (map[heart[0]][j] == '*') {
                rightArm++;
            } else {
                break;
            }
        }

        int waistEnd = heart[0] + 1; // 다리 계산 하려고
        for (int i = heart[0] + 1; i < N; i++) {
            if (map[i][heart[1]] == '*') {
                waist++;
                waistEnd = i;
            } else {
                break;
            }
        }

        for (int i = waistEnd + 1; i < N; i++) {
            if (map[i][heart[1] - 1] == '*') {
                leftLeg++;
            } else {
                break;
            }
        }

        for (int i = waistEnd + 1; i < N; i++) {
            if (map[i][heart[1] + 1] == '*') {
                rightLeg++;
            } else {
                break;
            }
        }

        System.out.println((heart[0] + 1) + " " + (heart[1] + 1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}
