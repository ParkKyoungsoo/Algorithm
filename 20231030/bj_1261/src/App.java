import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {

  int x;
  int y;
  int cnt;

  Node(int x, int y, int cnt) {
    this.x = x;
    this.y = y;
    this.cnt = cnt;
  }

  @Override
  public int compareTo(Node o) {
    return cnt - o.cnt;
  }

}

public class App {

  static int N, M;
  static int[][] map;
  static boolean[][] visited;
  static int[] dx = { 0, 1, 0, -1 };
  static int[] dy = { 1, 0, -1, 0 };
  static int minValue = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(br.readLine());
    N = Integer.parseInt(str.nextToken());
    M = Integer.parseInt(str.nextToken());

    map = new int[M][N];
    visited = new boolean[M][N];
    for (int i = 0; i < M; i++) {
      String input = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(input.charAt(j) + "");
      }
    }

    BFS(0, 0, 0);
    System.out.println(minValue);
  }

  private static void BFS(int x, int y, int cnt) {

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(x, y, cnt));
    visited[y][x] = true;

    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      int nowX = cur.x;
      int nowY = cur.y;
      int nowCnt = cur.cnt;

      if (nowY == M - 1 && nowX == N - 1) {
        minValue = Math.min(minValue, nowCnt);
      }

      for (int d = 0; d < 4; d++) {
        int nextX = nowX + dx[d];
        int nextY = nowY + dy[d];
        if (checkMap(nextX, nextY) && !visited[nextY][nextX]) {
          visited[nextY][nextX] = true;
          if (map[nextY][nextX] == 1) {
            pq.add(new Node(nextX, nextY, nowCnt + 1));
          } else {
            pq.add(new Node(nextX, nextY, nowCnt));
          }
        }
      }

    }
  }

  private static boolean checkMap(int nextX, int nextY) {
    return 0 <= nextX && nextX < N && 0 <= nextY && nextY < M;
  }
}
