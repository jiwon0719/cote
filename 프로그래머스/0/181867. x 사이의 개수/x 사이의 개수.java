import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String myString) {
        String[] str = myString.split("x", -1);
        
        // System.out.println(str.length);
        // System.out.println(Arrays.toString(str));
        
        int[] answer = new int[str.length];
        
        for(int i = 0; i < str.length; i++) {
            answer[i] = str[i].length();
        }
        
        return answer;
    }
}