import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9020_s_∞ÒµÂπŸ»Â¿«√ﬂ√¯ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			
			boolean[] prime = new boolean[n + 1];
			prime[0] = prime[1] = true;
			for(int j = 2; j <= n; j++ ) {
				if(!prime[j]) {
					for(int k = j * j; k <= n; k += j ) {
						prime[k] = true;
					}
				}
			}
			
			int half = n / 2;
			int p = half;
			int q = half;
			while(true) {
				if(!prime[p] && !prime[q]) {
					System.out.println(p + " " + q);
					break;
				}
				p--;
				q++;
				
			}
		}
	}
	
}
