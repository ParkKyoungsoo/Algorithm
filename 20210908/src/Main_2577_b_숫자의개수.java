import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2577_b_숫자의개수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		int result = a * b * c;
		char[] resultToArray = (result + "").toCharArray();
		int[] resultArray = new int[10];
		
		for(int i = 0; i < resultToArray.length; i++) {
			resultArray[Integer.parseInt(resultToArray[i] + "")]++;
		}
		
		for(int i = 0; i < resultArray.length; i++) {
			System.out.println(resultArray[i]);
		}
		
		
	}
}
