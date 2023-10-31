import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
  int x;
  int y;
  int rupee;

  Point(int x, int y, int rupee) {
    this.x = x;
    this.y = y;
    this.rupee = rupee;
  }

  @Override
  public int compareTo(Point o) {
    return rupee - o.rupee;
  }
}

public class App {
  static int N;
  static int[][] map;
  static boolean[][] visited;
  static int[] dx = { 1, 0, -1, 0 };
  static int[] dy = { 0, 1, 0, -1 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cnt = 0;
    while (true) {
      cnt++;
      N = Integer.parseInt(br.readLine());
      if (N == 0) {
        break;
      }
      map = new int[N][N];
      visited = new boolean[N][N];

      for (int i = 0; i < N; i++) {
        StringTokenizer str = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          map[i][j] = Integer.parseInt(str.nextToken());
        }
      }

      System.out.println("Problem " + cnt + ": " + bfs(0, N - 1));

    }
  }

  private static int bfs(int start, int end) {
    PriorityQueue<Point> pq = new PriorityQueue<>();
    pq.add(new Point(start, start, map[start][start]));
    int minValue = Integer.MAX_VALUE;

    while (!pq.isEmpty()) {
      Point cur = pq.poll();
      int nowX = cur.x;
      int nowY = cur.y;
      int nowRupee = cur.rupee;

      if (nowX == end && nowY == end) {
        if (minValue > nowRupee) {
          minValue = nowRupee;
        }
        break;
      }

      for (int d = 0; d < 4; d++) {
        int nextX = nowX + dx[d];
        int nextY = nowY + dy[d];

        if (check(nextX, nextY) && !visited[nextY][nextX]) {

          visited[nextY][nextX] = true;
          pq.add(new Point(nextX, nextY, cur.rupee + map[nextY][nextX]));
        }
      }
    }

    return minValue;
  }

  private static boolean check(int nextX, int nextY) {
    return 0 <= nextX && nextX < N && 0 <= nextY && nextY < N;
  }
}
