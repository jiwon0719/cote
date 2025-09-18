import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {        
        // 문자열 파싱해서 집합 저장
        s = s.substring(1, s.length() - 1);
        String[] sets = s.split("},\\{"); // 정규표현식에서 열리는 중괄호는 특수문자이므로 \\{ 처리
        
        List<Set<Integer>> setList = new ArrayList<>(); // 집합(Set)을 리스트에 담기
        
        for(String set : sets) {
            set = set.replace("{", "").replace("}", "");
            String[] elements = set.split(",");
            
            Set<Integer> currentSet = new HashSet<>();
            for(String element : elements) {
                currentSet.add(Integer.parseInt(element));
            }
            
            setList.add(currentSet);
        }
                              
        // 집합 크기별 정렬
        setList.sort((s1, s2) -> Integer.compare(s1.size(), s2.size())); // Integer.compare() 암기하기
                     
        // 새로운 원소 추출
        List<Integer> resultList = new ArrayList<>();
        Set<Integer> prevSet = new HashSet<>();
        
        for(Set<Integer> currentSet : setList) {
            currentSet.removeAll(prevSet); // Aset.removeAll(Bset);
            Integer newElement = currentSet.iterator().next(); // set.iterator().next(); 집합에서 원소를 꺼낼 수 있는 유일한 방법임. 집합은 인덱스의 개념이 없기 때문에 
            resultList.add(newElement);
            prevSet.add(newElement);
        }
        
        // return 반환
        int length = resultList.size();
        int[] answer = new int[length];
        int idx = 0;
        for(Integer i : resultList) {
            answer[idx++] = i;
        }
        
        return answer;
    }
}