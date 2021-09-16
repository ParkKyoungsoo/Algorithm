import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_s_외판원순회2 {

	public static int N;
	public static int MIN;
	public static int[][] map;
	public static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		MIN = Integer.MAX_VALUE;
		map = new int[N][N];
		for(int i = 0 ;i < N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(i,i,0);
		}
		
		System.out.println(MIN);
	}

	private static void dfs(int start, int now, int cost) {
		// TODO Auto-generated method stub
		if(allVisited()) {
			if(map[now][start] != 0) {
				MIN = Math.min(MIN, cost + map[now][start]);
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i] && map[now][i] != 0) {
				visited[i] = true;
				dfs(start, i, cost + map[now][i]);
				visited[i] = false;
			}
		}
	}

	private static boolean allVisited() {
		// TODO Auto-generated method stub
		for(int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				return false;
			}
		}
		return true;
	}
}
