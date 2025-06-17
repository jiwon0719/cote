import java.io.*;
import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i < A.length; i++) {
            int num = A[i] * B[B.length - i - 1];
            answer += num;
        }

        return answer;
    }
}