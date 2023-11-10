import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
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
  static int width, height;
  static char[][] map;
  static Razer[] target = new Razer[2];
  static int[] dy = { 1, 0, -1, 0 };
  static int[] dx = { 0, 1, 0, -1 };
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(br.readLine());

    width = Integer.parseInt(str.nextToken());
    height = Integer.parseInt(str.nextToken());

    map = new char[height][width];
    int index = 0;
    for (int h = 0; h < height; h++) {
      map[h] = br.readLine().toCharArray();
      for (int w = 0; w < width; w++) {
        if (map[h][w] == 'C') {
          target[index] = new Razer(w, h, -1, -5);
          index += 1;
        }
      }
    }
    dijkstra(target[0], target[1]);
    System.out.println(min);
  }

  private static void dijkstra(Razer start, Razer end) {
    PriorityQueue<Razer> pq = new PriorityQueue<>();
    int[][][] visited = new int[4][height][width];

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < height; j++) {
        Arrays.fill(visited[i][j], Integer.MAX_VALUE);
      }
    }
    pq.add(start);

    while (!pq.isEmpty()) {
      Razer cur = pq.poll();

      if (cur.x == end.x && cur.y == end.y) {
        min = Math.min(min, cur.reflex);
        continue;
      }

      for (int d = 0; d < 4; d++) {
        int nextY = cur.y + dy[d];
        int nextX = cur.x + dx[d];
        int reflexCnt = cur.dir == d ? cur.reflex : cur.reflex + 1;
        if (!isMap(nextX, nextY) || map[nextY][nextX] == '*' || Math.abs(cur.dir - d) == 2) {
          continue;
        }

        if (visited[d][nextY][nextX] > reflexCnt) {
          visited[d][nextY][nextX] = reflexCnt;
          pq.add(new Razer(nextX, nextY, reflexCnt, d));
        }
      }

    }

  }

  private static boolean isMap(int x, int y) {
    return 0 <= x && x < width && 0 <= y && y < height;
  }
}
