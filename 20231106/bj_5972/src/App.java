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
  static int N, M;
  static List<List<Node>> map = new ArrayList<>();
  static int[] valueMap;
  static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(br.readLine());
    N = Integer.parseInt(str.nextToken());
    M = Integer.parseInt(str.nextToken());

    valueMap = new int[N + 1];
    visited = new boolean[N + 1];
    Arrays.fill(valueMap, Integer.MAX_VALUE);

    for (int i = 0; i <= N; i++) {
      map.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      str = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(str.nextToken());
      int end = Integer.parseInt(str.nextToken());
      int value = Integer.parseInt(str.nextToken());
      map.get(start).add(new Node(end, value));
      map.get(end).add(new Node(start, value));
    }

    System.out.println(dijkstra(1, N));
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
