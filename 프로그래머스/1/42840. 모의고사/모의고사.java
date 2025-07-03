import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        
        int[] aAnswer = new int[] {1, 2, 3, 4, 5};
        int[] bAnswer = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] cAnswer = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int aGrade = 0, bGrade = 0, cGrade = 0;
        for(int i = 0; i < answers.length; i++) {
            int a = aAnswer[i % aAnswer.length];
            int b = bAnswer[i % bAnswer.length];
            int c = cAnswer[i % cAnswer.length];
            
            if(answers[i] == a) aGrade++;
            if(answers[i] == b) bGrade++;
            if(answers[i] == c) cGrade++;
            
        }
        
        int maxGrade = Math.max(aGrade, Math.max(bGrade, cGrade));
        
        if(maxGrade == aGrade) list.add(1);
        if(maxGrade == bGrade) list.add(2);
        if(maxGrade == cGrade) list.add(3);
        
        int size = list.size();
        int[] answer = new int[size];
        for(int i = 0; i < size; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}