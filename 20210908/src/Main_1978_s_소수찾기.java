import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1978_s_�Ҽ�ã�� {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		int[] input = new int[n];
		int MAX_VALUE = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(str.nextToken());
			input[i] = num;
			if(num > MAX_VALUE) {
				MAX_VALUE = num;
			}
		}
		boolean[] prime = new boolean[MAX_VALUE + 1];
		
		prime[0] = prime[1] = true;
		
		for(int i = 2; i * i <= MAX_VALUE; i++) {
			if(!prime[i]) {
				for(int j = i * i; j <= MAX_VALUE;  j+=i) {
					prime[i] = true;
				}
			}
		}
		
		int result = 0;
//		System.out.println(Arrays.toString(prime));
		for(int i = 0; i < n; i++) {
			if(!prime[input[i]]) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}
