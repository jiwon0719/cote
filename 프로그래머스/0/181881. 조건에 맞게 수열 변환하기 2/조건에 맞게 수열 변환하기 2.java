class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        boolean b = true;
        while(b) {
            int[] newArr = new int[arr.length];
            
            for(int i = 0; i < arr.length; i++) {
                int a = arr[i];
                if(a >= 50 && a % 2 == 0) {
                    newArr[i] = a / 2;
                } else if(a < 50 && a % 2 != 0) {
                    newArr[i] = (a * 2) + 1;
                } else {
                    newArr[i] = a;
                }
            }
            
            int cnt = 0;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == newArr[i]) {
                    cnt++;
                } 
            }
            
            if(cnt == arr.length) {
                b = false;
            }
            
            answer++;
            arr = newArr.clone();
        }
        
        return answer - 1;
    }
}