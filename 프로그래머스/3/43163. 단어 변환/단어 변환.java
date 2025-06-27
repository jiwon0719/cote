import java.io.*;
import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        int step = 0;
        queue.offer(begin);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            step++;
            
            for(int i = 0; i < size; i++) {
                String current = queue.poll();
                // words 배열단어와 한글자만 차이나는지 확인
                for(int k = 0; k < words.length; k++) {
                    String word = words[k];
                    int cnt = 0;
                    for(int j = 0; j < current.length(); j++) {
                        if(current.charAt(j) != word.charAt(j)) cnt++;
                    }
                    if(cnt == 1 && !visited[k]) { // 만약, 1글자만 차이난다면
                        if(word.equals(target)) return step;
                        
                        queue.offer(word);
                        visited[k] = true;
                    }
                }
            }
        }
        
        return 0;
    }
}