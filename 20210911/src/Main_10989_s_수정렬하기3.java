import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_10989_s_수정렬하기3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] cntArray = new int[10001];
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			cntArray[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i = 1; i < 10001; i++) {
			if(cntArray[i] == 0) continue;
			for(int j = 0; j < cntArray[i]; j++) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
