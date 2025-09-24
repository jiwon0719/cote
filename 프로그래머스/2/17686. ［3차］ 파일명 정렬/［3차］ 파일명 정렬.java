import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        // 배열에 담기
        String[][] arr = new String[files.length][4]; // head, number, tail, originalIndex
        
        // 파일명 쪼개기
        for(int j = 0; j < files.length; j++) {
            String file = files[j];
            int currIndex = 0;
            
            StringBuilder headSb = new StringBuilder();
            for(int i = 0; i < file.length(); i++) {
                char ch = file.charAt(i);
                if(!('0' <= ch && ch <= '9')) {
                    headSb.append(ch);
                } else {
                    currIndex = i;
                    break;
                }
            }
            
            StringBuilder numberSb = new StringBuilder();
            int numberLength = 0;
            for(int i = currIndex; i < file.length(); i++) {
                char ch = file.charAt(i);
                if('0' <= ch && ch <= '9' && numberLength <= 5) {
                    numberSb.append(ch);
                    numberLength++;
                } else {
                    currIndex = i;
                    break;
                }
            }
            
            StringBuilder tailSb = new StringBuilder();
            for(int i = currIndex; i < file.length(); i++) {
                char ch = file.charAt(i);
                tailSb.append(ch);
            }
            
            String head = headSb.toString();
            String number = numberSb.toString();
            String tail = tailSb.toString();
            
            arr[j][0] = head;
            arr[j][1] = number;
            arr[j][2] = tail;
            arr[j][3] = Integer.toString(j);
        }
        
        // 정렬하기
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                // 1. head 기준 정렬
                int headComparison = o1[0].compareToIgnoreCase(o2[0]);
                if(headComparison != 0) return headComparison;
                
                // 2. number 기준 정렬
                int num1 = Integer.parseInt(o1[1]);
                int num2 = Integer.parseInt(o2[1]);
                if(num1 != num2) return Integer.compare(num1, num2);
                
                // 3. 입력 순서 유지
                return 0;
            }
        });
        
        // 출력
        String[] answer = new String[files.length];
        int index = 0;
        for(String[] a : arr) {
            int originalIndex = Integer.parseInt(a[3]);
            answer[index++] = files[originalIndex];
        }
        
        return answer;
    }
}