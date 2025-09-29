import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] surveys, int[] choices) {
        String answer = "";
        // 8개 유형 저장할 배열
        // R T
        // C F
        // J M
        // A N
        int[][] arr = new int[4][2];
        char[][] charArr = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        
        
        // 4점 기준으로 어떤 유형 선택할지 고르기
        for(int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            int grade = Math.abs(choice - 4);
            char ch = ' '; // 공백으로 초기화
            
            if(choice < 4) {
                ch = surveys[i].charAt(0);
            } else if(choice == 4) {
                continue;
            } else {
                ch = surveys[i].charAt(1);
            }
            
            switch(ch) {
                case 'R':
                    arr[0][0] += grade;
                    break;
                case 'T':
                    arr[0][1] += grade;
                    break;
                case 'C':
                    arr[1][0] += grade;
                    break;
                case 'F':
                    arr[1][1] += grade;
                    break;
                case 'J':
                    arr[2][0] += grade;
                    break;
                case 'M':
                    arr[2][1] += grade;
                    break;
                case 'A':
                    arr[3][0] += grade;
                    break;
                case 'N':
                    arr[3][1] += grade;
                    break;
            }
        }
        
        // 배열 행별로 유형 선택하기
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++) {
            int leftNum = arr[i][0];
            int rightNum = arr[i][1];
            
            if(leftNum - rightNum > 0) {
                sb.append(charArr[i][0]);                                                
            } else if(leftNum - rightNum < 0) {
                sb.append(charArr[i][1]);
            } else { // 두 숫자가 같을 경우
                char leftChar = charArr[i][0];
                char rightChar = charArr[i][1];
                
                char selected = (leftChar < rightChar) ? leftChar : rightChar;
                sb.append(selected);
            }
        }
        
        answer = sb.toString();
        return answer;
    }
}