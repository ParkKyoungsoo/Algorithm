import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805_s_나무자르기 {
	
	static int N,M;
	static int[] trees;
	static int max;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		trees = new int[N];
		max = 0;
		str = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N ;i++) {
			trees[i] = Integer.parseInt(str.nextToken());
		}
		Arrays.sort(trees);
		treeCut(0, trees[N-1]);
		System.out.println(max);
		
	}

	private static void treeCut(int start, int end) {
		// TODO Auto-generated method stub
		if(start > end) return;
		
		int mid = (start + end) / 2;
		long result = 0;
		for(int i = 0; i < N; i++) {
			if(trees[i] - mid < 0) {
				result += 0;
			} else {
				result += (trees[i] - mid);
			}
		}

		if(result >= M) {
			if(max < mid) {
				max = mid;
			}
			treeCut(mid + 1, end);
		} else {
			treeCut(start, mid - 1);			
		}
//		if(result == M) {
//			System.out.println(mid);
//			return;
//		} else if(result > M) {
//			treeCut(mid + 1, end);
//		} else {
//			treeCut(start, mid - 1);			
//		}
		
	}
}
