import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2588_���� {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = 0;
		int b = 0;
		
		StringTokenizer str = new StringTokenizer(br.readLine());			
		a = Integer.parseInt(str.nextToken());
		str = new StringTokenizer(br.readLine());
		String nextInput = str.nextToken();
		b = Integer.parseInt(nextInput);
		char[] bArr = nextInput.toCharArray();
		
		System.out.println(Integer.parseInt(bArr[2] + "")* a);
		System.out.println(Integer.parseInt(bArr[1] + "")* a);
		System.out.println(Integer.parseInt(bArr[0] + "")* a);
		System.out.println(a * b);
		
	}
	
}
