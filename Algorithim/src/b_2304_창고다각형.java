import java.io.*;
import java.util.*;

public class b_2304_창고다각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 막대 개수
        Map<Integer, Integer> map = new HashMap<>();

        // 입력
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            map.put(key, val);
        }

        // 키 값 오름차순 정렬
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        // 최고 높이 찾기
        int maxHeight = 0;
        int maxPos = 0;
        for(int pos : keySet) {
            if(maxHeight < map.get(pos)) {
                maxHeight = map.get(pos);
                maxPos = pos;
            }
        }

        int answer = 0;

        // 왼쪽에서 최고점까지
        int currentHeight = 0;
        for(int i = 0; i < keySet.size(); i++) {
            int pos = keySet.get(i);
            if(pos > maxPos) break;

            currentHeight = Math.max(currentHeight, map.get(pos));

            // 면적 계산
            if(pos < maxPos) {
                int nextPos = keySet.get(i + 1);
                answer += currentHeight * (nextPos - pos);
            }
        }

        // 오른쪽에서 최고점까지
        currentHeight = 0;
        for(int i = keySet.size() - 1; i >= 0; i--) {
            int pos = keySet.get(i);
            if(pos <= maxPos) break;

            currentHeight = Math.max(currentHeight, map.get(pos));

            // 면적 계산
            if(i > 0) {
                int prevPos = keySet.get(i - 1);
                answer += currentHeight * (pos - prevPos);
            }
        }

        // 최고점 막대 추가
        answer += maxHeight;

        System.out.println(answer);
    }
}