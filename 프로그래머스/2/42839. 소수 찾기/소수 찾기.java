import java.io.*;
import java.util.*;

// 모든 경우의 수 구하기
// 앞자리가 0인 경우 제거하기
// 소수인지 판별하기 

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        int length = numbers.length();
        int[] input = new int[length];
     
        for(int i = 0; i < length; i++) {
            input[i] = (int)numbers.charAt(i) - '0';
        }
        
        Set<Integer> set = new HashSet<>();
        int[] output = new int[length];
        boolean[] isVisit = new boolean[length];
        
        // 모든 경우의 수 구하기
        for(int cnt = 1; cnt <= length; cnt++) {
            purmutation(input, set, output, isVisit, 0, length, cnt);
        }
        System.out.println(set.toString());
        
        //  앞자리 0인 경우 제거하기 - Integer.parseInt()가 자동으로 제거해줌
        
        // 소수인지 판별하기
        for(int num : set) {
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    public void purmutation(int[] input, Set<Integer> set, int[] output, boolean[] isVisit, int depth, int length, int cnt) {
        if(cnt == 0) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < depth; i++) {
                sb.append(output[i]);
            }
            set.add(Integer.parseInt(sb.toString()));
            return;
        }
        
        for(int i = 0; i < length; i++) {
            if(!isVisit[i]) {
                isVisit[i] = true;
                output[depth] = input[i];
                purmutation(input, set, output, isVisit, depth+1, length, cnt-1);
                isVisit[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if(num <= 1) return false;
        for(int i = 2; i < num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}