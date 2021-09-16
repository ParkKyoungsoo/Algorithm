import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805_s_나무자르기 {

	static int N, M;
	static long trees[];
	static long treeSum;
	static long MAX;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		MAX = -1;
		str = new StringTokenizer(br.readLine());
		trees = new long[N];
		for(int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(str.nextToken());
		}
	
		Arrays.sort(trees);
		
		cutTree(0, trees[N-1]);
		System.out.println(MAX);
	}

	private static void cutTree(long start, long end) {
		// TODO Auto-generated method stub
		if(start > end) {
			return;
		}
		
		long mid = (start + end) / 2;
		long cuttedTreeSum = 0;
		for(int i = 0; i < N; i++) {
			if(trees[i] - mid < 0) {
				cuttedTreeSum += 0;
			} else {
				cuttedTreeSum += (trees[i] - mid);				
			}
		}
		
		if(M <= cuttedTreeSum) {
			if(MAX < mid) {
				MAX = mid;
			}
			cutTree(mid + 1, end);
		} else {
			cutTree(start, mid - 1);
		}
		
	}
	
	
}
