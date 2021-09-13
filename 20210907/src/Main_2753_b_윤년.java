import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2753_b_À±³â {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int inputYear = Integer.parseInt(str.nextToken());
		int result = 0;
		
		if((inputYear % 4 == 0 && inputYear % 100 != 0) || inputYear % 400 == 0) {
			result = 1;
		} 
		System.out.println(result);
		
		
	}
}
