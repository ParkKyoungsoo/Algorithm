import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920_s_¼öÃ£±â {
	
	static int N;
	static int M;
	static int[] nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(str.nextToken());
		}
		
		Arrays.sort(nums);
		
		M = Integer.parseInt(br.readLine());
		str =  new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int checkNum = Integer.parseInt(str.nextToken());
			System.out.println(findNum(checkNum, 0, nums.length));
		}
		
	}

	private static int findNum(int checkNum, int start, int end) {
		// TODO Auto-generated method stub
		
		int mid = (start + end) / 2;
		if(mid >= end) {
			return 0;
		}
		
		if(nums[mid] == checkNum) {
			return 1;
		} else if(nums[mid] < checkNum) {
			return findNum(checkNum, mid + 1, end);
		} else {
			return findNum(checkNum, start, mid);
		}
	}
	
}
