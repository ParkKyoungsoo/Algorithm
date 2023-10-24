import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
  int end;
  int time;

  Node(int end, int time) {
    this.end = end;
    this.time = time;
  }

  @Override
  public int compareTo(Node o) {
    return time - o.time;
  }
}

public class App {

  static int N, K;
  static int[] map;
  static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(br.readLine());

    int mapSize = 100000;
    map = new int[mapSize + 1];
    Arrays.fill(map, Integer.MAX_VALUE);
    visited = new boolean[mapSize + 1];

    N = Integer.parseInt(str.nextToken());
    K = Integer.parseInt(str.nextToken());

    find(N, K);
  }

  private static void find(int start, int end) {

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
    map[start] = 0;
    pq.add(new int[] { start, 0 });

    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int curPos = cur[0];
      int curTime = cur[1];

      if (curPos == end) {
        System.out.println(curTime);
        break;
      }

      int[] dx = { -1, 1, 2 };
      if (!visited[curPos]) {
        visited[curPos] = true;
        for (int d = 0; d < dx.length; d++) {
          int next = curPos + dx[d];
          int nextTime = curTime + 1;
          if (d == 2) {
            next = curPos * 2;
            nextTime = curTime;
          }

          if (next < 0 || next > 100000 || visited[next]) {
            continue;
          }

          if (map[next] > nextTime) {
            map[next] = nextTime;
            pq.add(new int[] { next, nextTime });
          }

        }
      }
    }

  }
}
