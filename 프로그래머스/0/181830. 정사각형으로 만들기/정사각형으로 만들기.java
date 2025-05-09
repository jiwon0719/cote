class Solution {
    public int[][] solution(int[][] arr) {
        int rowlen = arr.length;
        int collen = arr[0].length;
        int anslen = Math.max(rowlen, collen);
        
        int[][] answer = new int[anslen][anslen];
        
        for(int i = 0; i < rowlen; i++) {
            for(int j = 0; j < collen; j++) {
                answer[i][j] = arr[i][j];
            }
        }
        
        return answer;
    }
}