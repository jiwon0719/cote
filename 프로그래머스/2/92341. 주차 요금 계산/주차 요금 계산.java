import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> list = new ArrayList<>();
        
        // 주차 요금 정리
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        Map<Integer, String> inCar = new HashMap<>();
        Map<Integer, Integer> totalTime = new HashMap<>();
        
        for(String r : records) {
            String[] record = r.split(" ");
            String time = record[0]; // 시각(HH:MM)
            int carNum = Integer.parseInt(record[1]); // 차량 번호(0000)
            String inOut = record[2];  // 내역(IN, OUT)
            
            if(inOut.equals("IN")) inCar.put(carNum, time);
            else {
                // 1. map에서 carNum에 맞는 입차시간 꺼내기
                String inTime = inCar.get(carNum);
                String outTime = time;
                
                // 2. split(":") 이용해서 입출차 시각 계산하기
                String[] inTimeArr = inTime.split(":");
                String[] outTimeArr = outTime.split(":");
                
                int inHour = Integer.parseInt(inTimeArr[0]);
                int inMin = Integer.parseInt(inTimeArr[1]);
                int outHour = Integer.parseInt(outTimeArr[0]);
                int outMin = Integer.parseInt(outTimeArr[1]);
                
                int inTotalTime = (inHour * 60) + inMin;
                int outTotalTime = (outHour * 60) + outMin;
                
                int total = outTotalTime - inTotalTime;
                
                // 3. total을 map(totalTime)에 저장하기
                totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + total);
                
                // 4. 출차 후 입차map에서 제거
                inCar.remove(carNum);
            }
        }
        
        // inCar에 담겨있는 입차기록 있다면, 출차를 23:59로 계산해서 map(totalTime)에 저장하기
        for(int carNum : inCar.keySet()) {
            String inTime = inCar.get(carNum);
            String[] inTimeArr = inTime.split(":");
            int inHour = Integer.parseInt(inTimeArr[0]);
            int inMin = Integer.parseInt(inTimeArr[1]);
            int outHour = 23;
            int outMin = 59;
            
            int inTotalTime = (inHour * 60) + inMin;
            int outTotalTime = (outHour * 60) + outMin;
                
            int total = outTotalTime - inTotalTime;
                
            totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + total);
        }
        
        // totalTime을 List해서 오름차순 정렬하기
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(totalTime.entrySet());
        // entryList.sort(Map.Entry.comparingByKey());
        entryList.sort((entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()));
        
        // totalTime 돌면서 기본시간빼고, 단위시간 계산하기
        for(Map.Entry<Integer, Integer> entry : entryList) {
            int carNum = entry.getKey();
            int total = entry.getValue();
            
            if(total <= basicTime) list.add(basicFee);
            else {
                double time = Math.ceil((total - basicTime) / (double) unitTime); 
                list.add(basicFee + (int)(time * unitFee));
            }
        }
        
        // 반환
        int size = list.size();
        int[] answer = new int[size];
        int idx = 0;
        for(int i : list) {
            answer[idx++] = i;
        }
        
        return answer;
    }
}