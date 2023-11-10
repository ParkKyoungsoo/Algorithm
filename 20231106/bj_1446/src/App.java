import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
  int end;
  int value;

  Node(int end, int value) {
    this.end = end;
    this.value = value;
  }

  @Override
  public int compareTo(Node o) {
    return value - o.value;
  }
}

public class App {
  static int N, D;
  static List<List<Node>> map = new ArrayList<>();
  static int[] valueMap;
  static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(br.readLine());
    N = Integer.parseInt(str.nextToken());
    D = Integer.parseInt(str.nextToken());

    valueMap = new int[D + 1];
    Arrays.fill(valueMap, Integer.MAX_VALUE);
    visited = new boolean[D + 1];

    for (int i = 0; i <= D; i++) {
      map.add(new ArrayList<>());
    }

    for (int i = 0; i < D; i++) {
      map.get(i).add(new Node(i + 1, 1));
    }

    for (int i = 0; i < N; i++) {
      str = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(str.nextToken());
      int end = Integer.parseInt(str.nextToken());
      int value = Integer.parseInt(str.nextToken());

      if (end > D || end - start <= value) {
        continue;
      }
      map.get(start).add(new Node(end, value));
    }

    System.out.println(dijkstra(0, D));

  }

  private static int dijkstra(int start, int end) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));
    valueMap[start] = 0;

    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      List<Node> nextList = map.get(cur.end);

      if (!visited[cur.end]) {
        visited[cur.end] = true;
        for (Node next : nextList) {
          if (valueMap[next.end] > valueMap[cur.end] + next.value) {
            valueMap[next.end] = valueMap[cur.end] + next.value;
            pq.add(new Node(next.end, valueMap[next.end]));
          }
        }
      }
    }
    return valueMap[end];
  }
}
