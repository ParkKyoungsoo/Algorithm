
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819_s_차이를최대로 {
	
	static int n;
	static int MAX;
	static int[] nums;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int[] selected = new int[n];
		nums = new int[n];
		visited = new boolean[n];
		MAX = Integer.MIN_VALUE;
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(str.nextToken());
		}
		
		createArray(0, selected);
		
		System.out.println(MAX);
		
	
	}

	private static void createArray(int index, int[] selected) {
		// TODO Auto-generated method stub
		if(index == n) {
			if(MAX < getMax(selected) ) {
				MAX = getMax(selected);
			}
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				selected[index] = nums[i];
				createArray(index + 1, selected);
				visited[i] = false;
			}
		}
		
	}

	private static int getMax(int[] selected) {
		// TODO Auto-generated method stub
		int result = 0;
		for(int i = 0; i < selected.length - 1; i++) {
			result += Math.abs(selected[i] - selected[i+ 1]);
		}
		
		return result;
	}
	
}
