class Solution {
    public int solution(int[] num_list) {
        int multiply = 1;
        int sumAndPow = 0;
        
        for(int num : num_list) {
            multiply *= num;
            sumAndPow += num;
        }
        
        sumAndPow *= sumAndPow;
        
        return (multiply < sumAndPow) ? 1 : 0;
    }
}