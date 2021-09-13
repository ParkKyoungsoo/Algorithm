import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_10819_s_차이를최대로 {
	
	public static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] num = new int[n];
		String number = br.readLine();
		StringTokenizer str = new StringTokenizer(number);
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(str.nextToken());
		}
		max = 0;
		permu(num, 0, n);
		System.out.println(max);
	}

	private static void permu(int[] array, int depth, int n) {
		// TODO Auto-generated method stub
		if(depth == n) {
			int sum = 0;
			for(int i = 0; i < n-1; i++) {
				sum += (Math.abs(array[i] - array[i+1]));
			}
			
			if(max < sum) {
				max = sum;
			}
			return;
		}

		for(int i = depth; i < n; i++) {
			swap(array, i, depth);
			permu(array, depth + 1, n);
			swap(array, i, depth);
		}
	}

	private static void swap(int[] array, int depth, int n) {
		// TODO Auto-generated method stub
		int tmp = array[depth];
		array[depth] = array[n];
		array[n] = tmp;
		
	}
}
