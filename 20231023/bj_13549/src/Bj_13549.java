import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj_13549 {

  public static class Node implements Comparable<Node> {
    int pos;
    int time;

    Node(int pos, int time) {
      this.pos = pos;
      this.time = time;
    }

    @Override
    public int compareTo(Bj_13549.Node o) {
      return time - o.time;
    }
  }

  static int N, K;
  static boolean[] visited;
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(br.readLine());

    int mapSize = 100000;
    visited = new boolean[mapSize + 1];

    N = Integer.parseInt(str.nextToken());
    K = Integer.parseInt(str.nextToken());

    System.out.println(bfs(N, K));

  }

  public static int bfs(int start, int end) {
    int minTime = Integer.MAX_VALUE;
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (!visited[cur.pos]) {
        visited[cur.pos] = true;
        if (cur.pos == end) {
          minTime = Math.min(minTime, cur.time);
        }

        if (cur.pos * 2 <= 100000 && !visited[cur.pos * 2]) {
          pq.add(new Node(cur.pos * 2, cur.time));
        }
        if (cur.pos + 1 <= 100000 && !visited[cur.pos + 1]) {
          pq.add(new Node(cur.pos + 1, cur.time + 1));
        }
        if (cur.pos - 1 >= 0 && !visited[cur.pos - 1]) {
          pq.add(new Node(cur.pos - 1, cur.time + 1));
        }

      }

    }

    return minTime;
  }
}
