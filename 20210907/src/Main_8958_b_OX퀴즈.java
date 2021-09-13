import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_8958_b_OXÄûÁî {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(str.nextToken());
		for(int i = 0; i < T; i++) {
			char[] inputArray = br.readLine().toCharArray();
			int score = 0;
			int totalScore = 0;
			for(int j = 0; j < inputArray.length; j++) {
				if(inputArray[j] == 'O') {
					score += 1;
				} else {
					score = 0;
				}
				totalScore += score; 
			}
			System.out.println(totalScore);
		}
	}
}
