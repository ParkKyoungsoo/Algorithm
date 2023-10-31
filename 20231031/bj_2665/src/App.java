import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Point implements Comparable<Point> {
    int x;
    int y;
    int cnt;

    Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Point o) {
        return cnt - o.cnt;
    }

    
}

public class App {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input.toCharArray()[j] + "");
            }
        }

        bfs(0, n - 1);
        System.out.println(minValue);
    }

    private static void bfs(int start, int end) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(start, start, 0));
        visited[start][start] = true;

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curCnt = cur.cnt;

            if (curX == end && curY == end) {
                if (minValue > cur.cnt) {
                    minValue = curCnt;
                }
            }

            for (int d = 0; d < 4; d++) {
                int nextX = curX + dx[d];
                int nextY = curY + dy[d];
                if (check(nextX, nextY) && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    if (map[nextY][nextX] == 0){
                        pq.add(new Point(nextX, nextY, curCnt + 1));
                    } else {
                        pq.add(new Point(nextX, nextY, curCnt));
                    }
                }
            }

        }
    }

    private static boolean check(int nextX, int nextY) {
        return 0 <= nextX && nextX < n && 0 <= nextY && nextY < n;
    }
}
