import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2]; // 최고, 최저
        
        int zeroCnt = 0;
        int matchCnt = 0;
        
        for(int lotto : lottos) {
            if(lotto == 0) {
                zeroCnt++;
                continue;
            }
            for(int winNum : win_nums) {
                if(lotto == winNum) {
                    matchCnt++;
                    continue;
                }
            }
        }
        
        int[] win = {6, 6, 5, 4, 3, 2, 1};
        answer[0] = win[zeroCnt + matchCnt];
        answer[1] = win[matchCnt];
        
        return answer;
    }
}