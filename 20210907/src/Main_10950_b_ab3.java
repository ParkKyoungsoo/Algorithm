import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10950_b_ab3 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(str.nextToken());
		for(int  i =0; i< T; i++) {
			str = new StringTokenizer(br.readLine());
			int a = 0;
			int b = 0;
			a = Integer.parseInt(str.nextToken());
			b = Integer.parseInt(str.nextToken());
			System.out.println(a + b);
		}
	}
}
