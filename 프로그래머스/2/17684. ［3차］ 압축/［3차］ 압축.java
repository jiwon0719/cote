import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        
        // 대문자 처리
        msg = msg.toUpperCase();
        
        // 1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다. 
        Map<String, Integer> index = new HashMap<>();
        
        for(int key = 1; key <= 26; key++) {
            char ch = (char)(64 + key);
            index.put(ch+"", key); // String.valueOf(ch)
        }
        int newValue = 27;
        
        /////////////////////////////////////////////////////////////
        int i = 0;
        while (i < msg.length()) {
            StringBuilder w = new StringBuilder();
            w.append(msg.charAt(i));

            int j = i + 1;
            // 가장 긴 문자열 w 찾기
            while (j <= msg.length() && index.containsKey(msg.substring(i, j))) {
                w.setLength(0); // reset
                w.append(msg.substring(i, j));
                j++;
            }

            list.add(index.get(w.toString())); // 색인 번호 출력

            // 다음 글자 붙인 w + c를 사전에 등록
            if (j <= msg.length()) {
                String wc = msg.substring(i, j); // i부터 j까지 (j는 포함 X)
                index.put(wc, newValue++);
            }

            i += w.length(); // w만큼 건너뜀
        }
        /////////////////////////////////////////////////////////////
        
        
        // 결과 반환
        int size = list.size();
        int[] answer = new int[size];
        int idx = 0;
        for(int li : list) {
            answer[idx++] = li;
        }
        
        return answer;
    }
}