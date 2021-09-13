import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main_1181_s_�ܾ����� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<String>[]stringArray = new ArrayList[51];
		
		for(int i = 0; i < 51; i++) {
			stringArray[i] = new ArrayList<String>();
		}
		
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			if(stringArray[input.length()].indexOf(input) == -1) {
				stringArray[input.length()].add(input);
			}
		}
		
		for(int i = 1; i < 51; i++) {
			if(stringArray[i].size() != 0) {
				Collections.sort(stringArray[i]);
			}
		}
		
		for(int i = 1; i < 51; i++) {
			if(stringArray[i].size() != 0) {
				for(int j = 0; j< stringArray[i].size(); j++) {
					sb.append(stringArray[i].get(j)).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}
