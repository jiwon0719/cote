import java.io.*;
import java.util.*;

// 가로 * 세로 = yellow되는 모든 경우의 수를 구한다(세로가 가로보다 커지기 전까지) > 리스트에 담기 
// (가로 * 2) + (세로 * 2) + 4 = brown인 조합을 찾아서 리턴한다. 

class Solution {
    public int[] solution(int brown, int yellow) {
        List<int[]> list = new ArrayList<>();
        
        for(int c = 1; c <= yellow; c++) {
            if(yellow % c == 0 && (yellow / c) >= c) {
                list.add(new int[] {(yellow / c), c}); 
            }
        }
        
        for(int[] arr : list) {
            System.out.println(arr[0] + " " + arr[1]);
        }
    
        for(int[] arr : list) {
            if(((arr[0] * 2) + (arr[1] * 2) + 4) == brown) return new int[] {arr[0] + 2, arr[1] + 2};
        }
        
        return new int[] {};
    }
}