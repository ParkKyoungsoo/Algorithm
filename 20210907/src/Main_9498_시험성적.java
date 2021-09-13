import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_9498_시험성적 {

	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int grade = Integer.parseInt(str.nextToken());
		String myGrade = "";
		
		if(90 <= grade && grade <= 100) {
			myGrade = "A";
		} else if(80 <= grade &&grade < 90) {
			myGrade = "B";
		} else if(70 <= grade && grade < 80) {
			myGrade = "C";
		} else if(60 <= grade && grade < 70) {
			myGrade = "D";
		} else {
			myGrade = "F";
		}
		
		System.out.println(myGrade);
	}
}
