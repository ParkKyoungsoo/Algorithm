import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2562_b_�ִ밪 {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int maxValue = Integer.MIN_VALUE;
		int index = 0;
		for(int i = 0; i < 9; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input > maxValue) {
				maxValue = input;
				index = i;
			}
		}
		System.out.println(maxValue);
		System.out.println(index + 1);
	}
}
