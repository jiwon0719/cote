import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        // 일단 다 소문자로 변환
        s = s.toLowerCase();
        
        StringBuilder sb = new StringBuilder(s);
        
        // 첫문자가 숫자가 아닐경우는 대문자로 
        if(!('0' <= sb.charAt(0) && sb.charAt(0) <= '9')) {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }
        
        // 띄어쓰기 다음단어만 대문자로 변환하기
        for(int i = 1; i < sb.length() - 1; i++) {
            if(sb.charAt(i) == ' ') {
                sb.setCharAt(i+1, Character.toUpperCase(sb.charAt(i+1)));
            }
        }
        
        return sb.toString();
    }
}