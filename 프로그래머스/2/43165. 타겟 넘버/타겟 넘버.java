import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    public int dfs(int[] numbers, int target, int index, int currentSum) {
        if(index == numbers.length) {
            if(currentSum == target) {
                return 1; 
            } else {
                return 0;
            }
        }
        
        int count = 0;
        count += dfs(numbers, target, index + 1, currentSum + numbers[index]);
        count += dfs(numbers, target, index + 1, currentSum - numbers[index]);
        return count;
    }
}