import java.util.Arrays;

public class p_소수찾기 {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4};
        int length = array.length;
        int[] output = new int[length];
        boolean[] isVisit = new boolean[length];

        for(int cnt=1; cnt<=length; cnt++) {
            permutation(array, output, isVisit, 0, length, cnt);
        }
        System.out.println();
    }

    public static void permutation(int[] array, int[] output, boolean[] isVisit, int depth, int length, int count) {
        if(count==0) {
            System.out.println(Arrays.toString(Arrays.stream(output).filter(i -> i!=0).toArray()));
            return;

        }
        for(int i=0; i<length; i++) {
            if(isVisit[i]!=true) {
                isVisit[i] = true;

                permutation(array, output, isVisit, depth+1, length, count-1);
                isVisit[i] = false;
            }
        }
    }
}
