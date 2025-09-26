import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Long> queue11 = new LinkedList<>();
        Queue<Long> queue22 = new LinkedList<>();
        
        long queue11Sum = 0;
        long queue22Sum = 0;
        
        for(int i = 0; i < queue1.length; i++) {
            long num1 = (long) queue1[i];
            long num2 = (long) queue2[i];
            
            queue11Sum += num1;
            queue22Sum += num2;
            queue11.offer(num1);
            queue22.offer(num2);
        }
        
        long sum = queue11Sum + queue22Sum;
        long targetNum = sum / 2;
        
        if(queue11Sum == queue22Sum) return 0;
        
        int maxOperations = queue1.length * 3;
        
        while (answer < maxOperations) {
            if (queue11Sum > queue22Sum) {
                long value = queue11.poll();
                queue22.offer(value);
                queue11Sum -= value;
                queue22Sum += value;
            } else {
                long value = queue22.poll();
                queue11.offer(value);
                queue22Sum -= value;
                queue11Sum += value;
            }

            answer++;

            if (queue11Sum == queue22Sum) {
                return answer;
            }
        }
        
        return -1;
    }
}
