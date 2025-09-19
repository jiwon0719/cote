import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String nums = Integer.toString(n, k); // 10진수 -> k진수, 타입 주의
        String[] numArr = nums.split("0"); // "" 들어감 주의
        
        for(String numStr : numArr) {
            if(numStr.equals("")) continue; // "" 처리
            Long num = Long.parseLong(numStr);
            
            // num이 소수인지 판별하기
            if(isPrime(num)) answer++;
        }
        return answer;
    }
    
    public boolean isPrime(Long num) {
        if(num < 2) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        
        for(long i = 3; i * i <= num; i += 2) {
            if(num % i == 0) return false;
        }
        return true;
    }
//     public boolean isPrime(int num) {
//         if(num < 2) return false;
        
//         boolean[] sieve = eratosthenes(num);
//         return sieve[num];
//     }
    
//     public boolean[] eratosthenes(int num) {
//         boolean[] isPrime = new boolean[num + 1];
        
//         // 2이상의 수는 우선 다 소수라고 가정
//         for(int i = 2; i <= num; i++) {
//             isPrime[i] = true;
//         }
        
//         // 2부터 루트num까지만 확인하면 된다
//         for(int i = 2; i * i <= num; i++) {
//             // i가 소수라면,
//             if(isPrime[i]) {
//                 // i의 배수들을 모두 지우기
//                 for(int j = i * i; j <= num; j += i) {
//                     isPrime[j] = false;
//                 }
//             }
//         }
        
//         return isPrime;
//     }
}