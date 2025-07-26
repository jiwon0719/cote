import java.io.*;
import java.util.*;

public class b_2607_비슷한단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            words[i] = word;
        }

        int answer = 0;
        for(int i = 1; i < N; i++) {
            Map<Character, Integer> map1 = new HashMap<>();
            for(char key : words[0].toCharArray()) {
                map1.put(key, map1.getOrDefault(key, 0) + 1);
            }

            Map<Character, Integer> map2 = new HashMap<>();
            for(char key : words[i].toCharArray()) {
                map2.put(key, map2.getOrDefault(key, 0) + 1);
            }

            // 모든 키를 Set에 저장
            // 메서드 : set.addAll(map1.keySet());
            Set<Character> allKeys = new HashSet<>();
            allKeys.addAll(map1.keySet());
            allKeys.addAll(map2.keySet());

            int totalDiff = 0;
            for(char key : allKeys) {
                int count1 = map1.getOrDefault(key, 0);
                int count2 = map2.getOrDefault(key, 0);
                totalDiff += Math.abs(count1 - count2); // 이게 핵심인데 이걸 어떻게 생각하냐고

            }

            boolean isSimilar = false;
            if(words[0].length() == words[i].length()) {
                if(totalDiff <= 2) isSimilar = true;
            } else {
                if(totalDiff <= 1) isSimilar = true;
            }

            if(isSimilar) answer++;
        }

        System.out.println(answer);
    }
}
