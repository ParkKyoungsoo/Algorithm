import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_1065_s_�Ѽ� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		if(n < 100) {
			result = n;
		} else  if( n <= 100 && n < 111) {
			result = 99;
		} else {
			result = 99;
			for(int i = 111; i <= n; i++) {
				char[] numToChar = (i + "").toCharArray();
				if((numToChar[0] - '0') - (numToChar[1] - '0') == (numToChar[1] - '0') - (numToChar[2] - '0')) {
					result++;
				}
				
			}
		}
		
		System.out.println(result);
	}
}
