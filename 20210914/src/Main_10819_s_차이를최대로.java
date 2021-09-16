import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10819_s_차이를최대로 {
	
	static int N;
	static int[] nums;
	static int[] createdArray;
	static boolean[] visited;
	static int MAX;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		MAX = Integer.MIN_VALUE;
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(str.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			createdArray = new int[N];
			visited = new boolean[N];
			createArray(i, 0);			
		}
		
		System.out.println(MAX);
	}

	private static void createArray(int start, int index) {
		// TODO Auto-generated method stub
		if(index == N) {
			getValue();
			return;
		}
		
		for(int i = 0; i < N ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				createdArray[index] = nums[i];
				createArray(start, index + 1);
				visited[i] = false;
				
			}
		}
	}

	private static void getValue() {
		// TODO Auto-generated method stub
		int result = 0;
		for(int i = 0; i < N - 1; i++) {
			result += Math.abs(createdArray[i] - createdArray[i + 1]);
		}
		
		if(result > MAX) {
			MAX = result;
		}
		
	}
}
