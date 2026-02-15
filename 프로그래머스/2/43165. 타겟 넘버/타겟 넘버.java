import java.io.*;
import java.util.*;

class Solution {
    
    private int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int currentSum, int i) {
        if(i == numbers.length) {
            if(currentSum == target) answer++;
            return;
        }
        
        dfs(numbers, target, currentSum + numbers[i], i + 1);
        dfs(numbers, target, currentSum - numbers[i], i + 1);
    }
}