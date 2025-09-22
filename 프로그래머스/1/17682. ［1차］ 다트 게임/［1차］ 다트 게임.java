import java.io.*;
import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[][] arr = new int[3][3];
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                arr[i][j] = 1;
            }
        }
        
        int currentScore = 0;
        int index = 0;
        for(int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            
            if(ch == 'S') {
                arr[index][1] = 1;
                index++;
                currentScore = 0; 
            } else if(ch == 'D') {
                arr[index][1] = 2;
                index++;
                currentScore = 0; 
            } else if(ch == 'T') {
                arr[index][1] = 3;
                index++;
                currentScore = 0; 
            } else if(ch == '*') {
                if(index == 1) arr[index-1][2] *= 2;
                else if(index >= 2) {
                    arr[index-1][2] *= 2;
                    arr[index-2][2] *= 2;
                }
            } else if(ch == '#') {
                arr[index-1][2] *= -1;
            } else {
                if(currentScore == 1 && ch == '0') {
                    currentScore = 10;
                } else {
                    currentScore = Integer.parseInt(String.valueOf(ch));
                }
                arr[index][0] = currentScore;
            }
        }
        
        // 계산
        int first = ((int)(Math.pow(arr[0][0], arr[0][1])) * arr[0][2]);
        int second = ((int)(Math.pow(arr[1][0], arr[1][1])) * arr[1][2]);
        int third = ((int)(Math.pow(arr[2][0], arr[2][1])) * arr[2][2]);
        
        answer = first + second + third;
        return answer;
    }
}