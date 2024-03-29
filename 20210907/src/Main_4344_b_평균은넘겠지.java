import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main_4344_b_������Ѱ��� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < C; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(str.nextToken());
			int[] gradeArr = new int[n];
			int gradeSum = 0;
			for(int j = 0; j < n; j++) {
				gradeArr[j] = Integer.parseInt(str.nextToken());
				gradeSum += gradeArr[j];
			}
			float avgGrade = (float) gradeSum / n;
			int passedStd = 0;
			for(int j = 0; j < n; j++) {
				if(gradeArr[j] > avgGrade) {
					passedStd++;
				}
			}
			double result = (double) (((double) passedStd /(double) n) * 100.0);
			System.out.println(String.format("%.3f",result)+"%");
		
		}
	}
}
