import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String word = br.readLine();

            // 0. M보다 길이가 작은 단어는 제거한다.
            if(word.length() >= M) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

       List<String> words = new ArrayList<>(map.keySet());
        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 1. 자주 나오는 단어일수록 앞에 배치한다.
                int freq1 = map.get(o1);
                int freq2 = map.get(o2);
                if(freq1 != freq2) {
                    return freq2 -  freq1; // 내림차순
                }

                // 2. 해당 단어의 길이가 길수록 앞에 배치한다.
                int len1 = o1.length();
                int len2 = o2.length();
                if(len1 != len2) {
                    return len2 -  len1; // 내림차순
                }

                // 3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다.
                return o1.compareTo(o2); // 오름차순
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String word : words) {
            sb.append(word).append('\n');
        }

        System.out.print(sb);
    }
}
