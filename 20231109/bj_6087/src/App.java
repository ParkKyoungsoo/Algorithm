import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Razer implements Comparable<Razer> {
  int x;
  int y;
  int reflex;
  int dir;

  Razer(int x, int y, int reflex, int dir) {
    this.x = x;
    this.y = y;
    this.reflex = reflex;
    this.dir = dir;
  }

  @Override
  public int compareTo(Razer o) {
    return reflex - o.reflex;
  }

}

public class App {
  static char[][] map;
  static int[][] visited;
  static int width, height;
  static int[] dy = { 1, 0, -1, 0 };
  static int[] dx = { 0, 1, 0, -1 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(br.readLine());
    boolean flag = true;
    // x
    width = Integer.parseInt(str.nextToken());
    // y
    height = Integer.parseInt(str.nextToken());

    map = new char[height][width];
    visited = new int[height][width];
    for (int i = 0; i < visited.length; i++) {
      for (int j = 0; j < visited[i].length; j++) {
        visited[i][j] = width * height;
      }
    }

    int startPointY = 0;
    int startPointX = 0;
    int endPointY = 0;
    int endPointX = 0;

    for (int h = 0; h < height; h++) {
      map[h] = br.readLine().toCharArray();
      for (int w = 0; w < width; w++) {
        if (map[h][w] == 'C') {
          if (flag) {
            startPointY = h;
            startPointX = w;
            flag = false;
          } else {
            endPointY = h;
            endPointX = w;
          }
        }
      }
    }

    bfs(startPointY, startPointX, endPointY, endPointX);
    System.out.println(visited[endPointY][endPointX]);
  }

  private static void bfs(int startPointY, int startPointX, int endPointY, int endPointX) {
    Queue<Razer> pq = new PriorityQueue<>();
    pq.add(new Razer(startPointX, startPointY, 0, -1));
    visited[startPointY][startPointX] = 0;

    while (!pq.isEmpty()) {
      Razer cur = pq.poll();

      for (int d = 0; d < 4; d++) {
        int nextY = cur.y + dy[d];
        int nextX = cur.x + dx[d];

        if (!checkMap(nextY, nextX) || map[nextY][nextX] == '*') {
          continue;
        }
        if (cur.reflex > visited[nextY][nextX]) {
          continue;
        }
        if (cur.dir != d && cur.dir != -1) {
          if (visited[nextY][nextX] >= cur.reflex + 1) {
            visited[nextY][nextX] = cur.reflex + 1;
            pq.add(new Razer(nextX, nextY, cur.reflex + 1, d));
          }
        } else {
          if (visited[nextY][nextX] >= cur.reflex) {
            visited[nextY][nextX] = cur.reflex;
            pq.add(new Razer(nextX, nextY, cur.reflex, d));
          }
        }
      }

    }
  }

  private static boolean checkMap(int y, int x) {
    return 0 <= y && y < height && 0 <= x && x < width;
  }
}
