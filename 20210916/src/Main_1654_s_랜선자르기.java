import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1654_s_랜선자르기 {

	static int K, N;
	static long[] lenCable;
	static long MAX;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		K = Integer.parseInt(str.nextToken());
		N = Integer.parseInt(str.nextToken());
		lenCable = new long[K];
		MAX = -1;
		for(int i = 0; i < K; i++ ) {
			lenCable[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(lenCable);
		cutCable(1, lenCable[K-1]);			
		
		System.out.println(MAX);
		
	}

	private static void cutCable(long start, long end) {
		if(start > end) {
			return;
		}
		long mid = (start + end) / 2;
		long cnt = 0;
		for(int i = 0; i < K; i++)  {
			cnt += (lenCable[i] / mid);
		}

		if(cnt >= N) {
			if(MAX < mid) {
				MAX = mid;
			}
			cutCable(mid + 1, end);
		} else {
			cutCable(start, mid - 1);
		}
		
	}
}
