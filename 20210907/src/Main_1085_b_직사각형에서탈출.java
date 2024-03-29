import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1085_b_직사각형에서탈출 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(str.nextToken());
		int y = Integer.parseInt(str.nextToken());
		int w = Integer.parseInt(str.nextToken());
		int h = Integer.parseInt(str.nextToken());
		
		int heightEscapeLength = 0;
		int widthEscapeLegnth = 0;
		
		if(Float.parseFloat(w + "") / 2 > x) {
			widthEscapeLegnth = x;
		} else {
			widthEscapeLegnth = w - x;
		}
		
		if(Float.parseFloat(h + "") / 2 > y) {
			heightEscapeLength = y;
		} else {
			heightEscapeLength = h - y;
		}
		
		System.out.println(widthEscapeLegnth > heightEscapeLength ? heightEscapeLength :widthEscapeLegnth);
		
	}
	
}
