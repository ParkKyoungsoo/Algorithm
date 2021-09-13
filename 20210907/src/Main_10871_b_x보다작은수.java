import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10871_b_x보다작은수 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(str.nextToken());
		int x = Integer.parseInt(str.nextToken());
		str = new StringTokenizer(br.readLine());
		String output = "";
		
		for(int i = 0; i < n; i++) {
			int nextNum = Integer.parseInt(str.nextToken());
			if(nextNum < x) {
				output += (nextNum + " ");
			}
		}
		
		System.out.println(output.substring(0, output.length() - 1));
	}
}
