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
  // N번으로의 최단거리
  static int N, E;
  static List<List<Node>> map;
  static int[] valueMap;
  static boolean[] visited;
  static int v1, v2;
  static int minValue = 200000000;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(br.readLine());
    N = Integer.parseInt(str.nextToken());
    E = Integer.parseInt(str.nextToken());

    valueMap = new int[N + 1];
    Arrays.fill(valueMap, Integer.MAX_VALUE);
    visited = new boolean[N + 1];

    map = new ArrayList<>();

    for (int i = 0; i <= N; i++) {
      map.add(i, new ArrayList<>());
    }

    for (int i = 0; i < E; i++) {
      str = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(str.nextToken());
      int end = Integer.parseInt(str.nextToken());
      int value = Integer.parseInt(str.nextToken());
      map.get(start).add(new Node(end, value));
      map.get(end).add(new Node(start, value));
    }

    str = new StringTokenizer(br.readLine());
    v1 = Integer.parseInt(str.nextToken());
    v2 = Integer.parseInt(str.nextToken());

    int route1 = 0;
    int route2 = 0;
    // start - v1 - v2 - end
    route1 += dijkstra(1, v1);
    route1 += dijkstra(v1, v2);
    route1 += dijkstra(v2, N);

    // start - v2 - v1 - end
    route2 += dijkstra(1, v2);
    route2 += dijkstra(v2, v1);
    route2 += dijkstra(v1, N);

    int result = (route1 >= minValue && route2 >= minValue) ? -1 : Math.min(route1, route2);
    System.out.println(result);

  }

  private static int dijkstra(int start, int end) {
    Arrays.fill(visited, false);
    Arrays.fill(valueMap, minValue);

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));
    valueMap[start] = 0;
    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      List<Node> nextList = map.get(cur.end);
      if (!visited[cur.end]) {
        visited[cur.end] = true;
        for (Node next : nextList) {
          if (!visited[next.end] && valueMap[next.end] > valueMap[cur.end] + next.value) {
            valueMap[next.end] = valueMap[cur.end] + next.value;
            pq.add(new Node(next.end, valueMap[cur.end] + next.value));
          }
        }
      }

    }
    return valueMap[end];
  }
}
