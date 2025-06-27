import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    public int dfs(int[] numbers, int target, int currentSum, int i) {
        if(i == numbers.length) {
            if(currentSum == target) {
                return 1; 
            } else {
                return 0;
            }
        }
        
        int answer = 0;
        answer += dfs(numbers, target, currentSum + numbers[i], i + 1);
        answer += dfs(numbers, target, currentSum - numbers[i], i + 1);
        return answer;
    }
}