import java.io.*;
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        // 대소문자 구분 안함 처리
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // 다중집합 원소 > Map에 저장
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        // 두 글자씩 끊기
        for(int i = 0; i < str1.length() - 1; i++) {
            char element1 = str1.charAt(i);
            char element2 = str1.charAt(i+1);
            
            // 영문자 외 글자쌍 확인 > 있으면 넘어가
            if(element1 < 97 || element1 > 122 || element2 < 97 || element2 > 122) continue;
            
            // 다중집합 원소
            StringBuilder sb = new StringBuilder();
            sb.append(element1);
            sb.append(element2);
            String element = sb.toString();
            
            // 원소가 map에 있으면 ++, 없으면 키-값 추가
            map1.put(element, map1.getOrDefault(element, 0) + 1);
        }
        
        for(int i = 0; i < str2.length() - 1; i++) {
            char element1 = str2.charAt(i);
            char element2 = str2.charAt(i+1);
            
            // 영문자 외 글자쌍 확인 > 있으면 넘어가
            if(element1 < 97 || element1 > 122 || element2 < 97 || element2 > 122) continue;
            
            // 다중집합 원소
            StringBuilder sb = new StringBuilder();
            sb.append(element1);
            sb.append(element2);
            String element = sb.toString();
            
            // 원소가 map에 있으면 ++, 없으면 키-값 추가
            map2.put(element, map2.getOrDefault(element, 0) + 1);
        }
        
        // 두 집합모두 공집합일 경우, 65536 반환
        if(map1.size() == 0 && map2.size() == 0) return 65536;
        
        // 유사도 계산하기(교집합)
        int intersection = 0;
        int union = 0;
        for(String key : map1.keySet()) {
            if(map2.containsKey(key)) { // 중복되는 원소가 있으면
                intersection += Math.min(map1.get(key), map2.get(key));
                union += Math.max(map1.get(key), map2.get(key));
            } else {
                union += map1.get(key);
            }
        }
        
        for(String key : map2.keySet()) {
            if(!map1.containsKey(key)) {
                union += map2.get(key);
            }
        }
        
        // 유사도 값 계산 : 실수이므로 dolble형 사용하기
        double similarity = (double) intersection / union;
        answer = (int) (similarity * 65536);
        
        return answer;
    }
}