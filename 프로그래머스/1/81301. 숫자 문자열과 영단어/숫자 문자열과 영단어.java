import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        // 하나씩 읽기
        // 숫자면 > 바로 answer++
        // 문자면 > str로 저장붙이고 > str 중에 완성되는 단어 있는지 보기(map으로 매칭) 
        // 매칭 되면 str 삭제하고 answer++, 안되면 다음 턴
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        StringBuilder sb = new StringBuilder();
        StringBuilder str = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if('0' <= ch && ch <= '9') {
                sb.append(ch);
            } else {
                str.append(ch);
                for(String key : map.keySet()) {
                    if(str.toString().equals(key)) {
                        sb.append(map.get(key));
                        str.setLength(0);
                    }
                }
            }
        }
        
        
        return Integer.parseInt(sb.toString());
    }
}