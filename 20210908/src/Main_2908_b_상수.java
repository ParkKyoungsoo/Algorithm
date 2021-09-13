import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2908_b_��� {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		String a = str.nextToken();
		String b = str.nextToken();
		
		int reverseA = Integer.parseInt(a.toCharArray()[2] + "" + a.toCharArray()[1] + "" + a.toCharArray()[0] + "");
		int reverseB = Integer.parseInt(b.toCharArray()[2] + "" +  b.toCharArray()[1] + "" + b.toCharArray()[0] + "");
		System.out.println(reverseA > reverseB ? reverseA : reverseB);
	}
}
