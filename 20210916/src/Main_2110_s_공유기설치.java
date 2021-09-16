import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110_s_공유기설치 {

	static int N, C;
	static int[] home;
	static int MAX;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		MAX = Integer.MIN_VALUE;
		home = new int[N];
		for(int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(home);
		
		installHub(1, home[N-1]);
		System.out.println(MAX);
	}

	private static void installHub(int start, int end) {
		// TODO Auto-generated method stub
		if(start > end) {
			return;
		}
		
		int mid = (start + end) / 2;
		int cnt = 1;
		int lastIndex = 0;
		for(int i = 1; i < N; i++) {
			if(home[i] - home[lastIndex] >= mid) {

				lastIndex = i;
				cnt++;
			}
		}
		
		if(cnt >= C) {
			if(MAX < mid) {
				MAX = mid;
			}
			installHub(mid + 1, end);
		} else {
			installHub(start, mid - 1);
		}
		
	}
	
}
