import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2739_b_±¸±¸´Ü {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int input = Integer.parseInt(str.nextToken());
		for(int i =1; i <= 9; i++ ) {
			System.out.println(input + " * " + i +" = " + (input * i));
		}
	}
}
