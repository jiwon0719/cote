import java.io.*;
import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int maxLength = t * m;
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while(true) {
            sb.append(Integer.toString(num++, n));
            if(sb.length() >= maxLength) break;
        }
        String word = sb.toString();
        
        StringBuilder answerSb = new StringBuilder();
        int pp = p - 1;
        for(int i = 0; i < t; i++) {
            char ch = word.charAt(pp);
            answerSb.append(ch);
            pp += m;
        }
        
        answer = answerSb.toString().toUpperCase();
        return answer;
    }
}