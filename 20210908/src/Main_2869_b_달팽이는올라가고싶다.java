import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2869_b_달팽이는올라가고싶다 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int up = Integer.parseInt(str.nextToken());
		int down = Integer.parseInt(str.nextToken());
		int height =  Integer.parseInt(str.nextToken());
		System.out.println(((height - down - 1) / (up - down)) + 1);
		
	}
}
