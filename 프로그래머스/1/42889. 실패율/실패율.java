import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        Map<Integer, Double> faultpercent = new HashMap<>();
        for(int stageNum = 1; stageNum <= N; stageNum++) {
            double a = 0;
            double b = 0;
            for(int i = 0; i < stages.length; i++){
                if(stages[i] == stageNum) a++;
                if(stages[i] >= stageNum) b++;
            }
            if(b == 0) faultpercent.put(stageNum, 0.0);
            else faultpercent.put(stageNum, (a / b));
        }
        
        // Map 정렬하기 -> entryMap 이용
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(faultpercent.entrySet());
        entryList.sort((entry1, entry2) -> {
            int value = Double.compare(entry2.getValue(), entry1.getValue()); // 내림차순
            if(value != 0) {
                return value;
            } else {
                return entry1.getKey().compareTo(entry2.getKey()); // 오름차순
            }
        });
        
        // 출력
        int idx = 0;
        for(Map.Entry<Integer, Double> entry : entryList) {
            answer[idx++] = (int) entry.getKey();
        }
        
        return answer;
    }
}