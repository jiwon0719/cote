import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        // 십진수 > 이진수로 바꾼다. 9 = 01001, 30 = 11110
        // 해당 숫자를 하나씩 끊어서 1이면 벽, 0이면 공백으로 처리한다. 
        // 끝나면 sb를 answer에 저장한다. 
        for(int i = 0; i < n; i++) {
String arrBinary1 = String.format("%" + n + "s", Integer.toBinaryString(arr1[i])).replace(' ', '0');
String arrBinary2 = String.format("%" + n + "s", Integer.toBinaryString(arr2[i])).replace(' ', '0');
            
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < arrBinary1.length(); j++) {
                int arrInt1 = arrBinary1.charAt(j) - '0';
                int arrInt2 = arrBinary2.charAt(j) - '0';
                
                if(arrInt1 == 0 && arrInt2 == 0) {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}