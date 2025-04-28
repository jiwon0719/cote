class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        
        int tmp = arr1.length - arr2.length;
        
        if(tmp != 0) {
            return tmp > 0 ? 1 : -1;
        }
        
        int arr1Sum = 0;
        int arr2Sum = 0;
        for(int a : arr1) {
            arr1Sum += a;
        }
        for(int b : arr2) {
            arr2Sum += b;
        }
        
        if(arr1Sum - arr2Sum > 0) return 1;
        else if(arr1Sum - arr2Sum < 0) return -1;
        else return 0;
    }
}