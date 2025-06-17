// import java.io.*;
// import java.util.*;

// class Solution {
//     boolean solution(String s) {
//         String[] arr = s.split("");

//         // 처음부터 )가 먼저 나오면 무조건 false임
//         if(arr[0].equals(")")) return false;
        
//         Stack<String> stack = new Stack<>();
//         for(String str : arr) {
//             if(stack.isEmpty()) stack.push(str);
//             else {
//                 String popStr = stack.peek();
//                 if(str.equals(")") && popStr.equals("(")) stack.pop(); 
//                 else stack.push(str);
//             }
//         }
                
//         return stack.isEmpty() ? true : false;
//     }
// }

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

		// 괄호를 저장하기 위한 문자열 스택 생성
        Stack<Character> stack = new Stack<>();
        
        // 반복문을 활용하여 괄호 확인
        for (char c : s.toCharArray()) {
            // 만약 열린 괄호인 경우
            if (c == '(') {
                // 스택에 문자 c 추가
                stack.push(c);
            }
            
            // 만약 닫힌 괄호일 경우
            if (c == ')') {
                // 만약 스택이 비어있을 경우 
                if (stack.isEmpty()) {
                    // false 반환
                    return false;
                }
                // 마지막 값 삭제
                stack.pop();
            }
        }
        
        // 만약 스택이 비어있지 않은 경우
        if (!stack.isEmpty()) {
            // answer에 false 저장
            answer = false;
        }
        
        // answer 반환
        return answer;
    }
}