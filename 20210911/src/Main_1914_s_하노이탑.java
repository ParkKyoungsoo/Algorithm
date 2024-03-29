import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main_1914_s_�ϳ���ž {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int moveCnt = 0;
		BigInteger bi = new BigInteger("2");
		BigInteger result = bi.pow(n).subtract(BigInteger.ONE);
		System.out.println(result);
		if(n <= 20) {
			hanoi(n, 1,2,3);
		}
	}

	private static void hanoi(int n, int source, int by, int destiny) {
		// TODO Auto-generated method stub
		if(n == 1) {
			System.out.println(source + " " + destiny);
			return;
		}
		
		hanoi(n-1, source, destiny, by);
		System.out.println(source + " " + destiny);
		hanoi(n-1, by, source, destiny);

	}
	
}
