import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2675_b_문자열반복 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(str.nextToken());
			char[] s = str.nextToken().toCharArray();
			String result = "";
			for(int j = 0; j < s.length; j++) {
				for(int k = 0; k < r; k++) {
					result += (s[j] + "");
				}
			}
			System.out.println(result);
		}
		
	}
}
