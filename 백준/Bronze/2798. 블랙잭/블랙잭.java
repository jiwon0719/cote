import java.util.Scanner;

public class Main {
	
	static int N, M, max;
	static int[] data, sel;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		M = sc.nextInt();
		max = 0;
		data = new int[N];
		sel = new int[3];
		for(int i = 0; i < N; i++) {
			data[i] = sc.nextInt(); 
		}
		
		// 조합
		comb(0, 0);
		
		System.out.println(max);
	}

	private static void comb(int idx, int sidx) {
		if(sidx == 3) {
			int count = 0;
			for(int i = 0; i < 3; i++) {
				count += sel[i];
			}
			if(count <= M) {
				max = Math.max(count, max);
			}
			return;
		}
		
		
		if(idx == N) return;
		
		sel[sidx] = data[idx]; 
		comb(idx+ 1, sidx + 1);
		comb(idx+ 1, sidx);
	}
}
