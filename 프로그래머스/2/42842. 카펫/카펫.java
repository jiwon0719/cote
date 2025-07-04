import java.io.*;
import java.util.*;

// 가로 * 세로 = yellow되는 모든 경우의 수를 구한다(세로가 가로보다 커지기 전까지) > 리스트에 담기 
// (가로 * 2) + (세로 * 2) + 4 = brown인 조합을 찾아서 리턴한다. 

// class Solution {
//     public int[] solution(int brown, int yellow) {
//         List<int[]> list = new ArrayList<>();
        
//         for(int c = 1; c <= yellow; c++) {
//             if(yellow % c == 0 && (yellow / c) >= c) {
//                 list.add(new int[] {(yellow / c), c}); 
//             }
//         }
        
//         for(int[] arr : list) {
//             System.out.println(arr[0] + " " + arr[1]);
//         }
    
//         for(int[] arr : list) {
//             if(((arr[0] * 2) + (arr[1] * 2) + 4) == brown) return new int[] {arr[0] + 2, arr[1] + 2};
//         }
        
//         return new int[] {};
//     }
// }


class Solution {
    public int[] solution(int brown, int yellow) {
        // yellow의 제곱근까지만 확인하여 약수 쌍을 찾음
        for(int height = 1; height <= Math.sqrt(yellow); height++) {
            if(yellow % height == 0) {
                int width = yellow / height;
                
                // 갈색 격자 수가 맞는지 확인
                // 갈색 = (전체 가로 * 2) + (전체 세로 * 2) - 4
                // 또는 갈색 = (노란색 가로 + 2) * 2 + (노란색 세로) * 2
                if((width + 2) * 2 + height * 2 == brown) {
                    return new int[] {width + 2, height + 2};
                }
            }
        }
        
        return new int[] {};
    }
}