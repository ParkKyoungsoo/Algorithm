import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920_s_¼öÃ£±â {

	static int N,M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(str.nextToken());
		}
		Arrays.sort(nums);
		
		M = Integer.parseInt(br.readLine());
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			System.out.println(binarySearch(0, N,nums, Integer.parseInt(str.nextToken())));
		}
		
		
	}

	private static int binarySearch(int start, int end, int[] nums, int target) {
		// TODO Auto-generated method stub
		int mid = (start + end) / 2;
		if(mid >= end) {
			return 0;
		}
		
		if(nums[mid] == target) {
			return 1;
		} else if(nums[mid] < target) {
			return binarySearch(mid + 1, end, nums, target);
		} else  {
			return binarySearch(start, mid, nums,target);
		}
		
		
	}
}
