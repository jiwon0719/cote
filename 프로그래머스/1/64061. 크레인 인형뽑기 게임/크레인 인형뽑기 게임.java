import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int move : moves) {
            int c = move - 1;
            for(int r = 0; r < board.length; r++) {
                int doll = board[r][c];
                if(doll == 0) continue;
                
                board[r][c] = 0;
                if(stack.isEmpty()) {
                    stack.push(doll);
                } else {
                    int check = stack.peek(); // 비어있는데 호출하면 NoSuchElementException 예외 발생
                    if(check == doll) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(doll);
                    }
                }
                break;
            }
        }
        
        
        return answer;
    }
}