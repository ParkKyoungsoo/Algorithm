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
  List<Integer> path;

  Node(int end, int value, List<Integer> path) {
    this.end = end;
    this.value = value;
    this.path = path;
  }

  @Override
  public int compareTo(Node o) {
    return value - o.value;
  }

}

public class App {
  static int n, m;
  static List<List<Node>> map = new ArrayList<>();
  static int[] valueMap;
  static List<List<Integer>> pathMap = new ArrayList<>();
  static boolean[] visited;
  static int sour, dest;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = null;
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    valueMap = new int[n + 1];
    visited = new boolean[n + 1];
    Arrays.fill(valueMap, Integer.MAX_VALUE);

    for (int i = 0; i <= n; i++) {
      map.add(new ArrayList<>());
      pathMap.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      str = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(str.nextToken());
      int end = Integer.parseInt(str.nextToken());
      int value = Integer.parseInt(str.nextToken());
      map.get(start).add(new Node(end, value, new ArrayList<>()));
    }

    str = new StringTokenizer(br.readLine());
    sour = Integer.parseInt(str.nextToken());
    dest = Integer.parseInt(str.nextToken());

    System.out.println(dijkstra(sour, dest));
    List<Integer> resultPath = pathMap.get(dest);
    System.out.println(resultPath.size());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < resultPath.size(); i++) {
      sb.append(resultPath.get(i));
      if (i != resultPath.size() - 1) {
        sb.append(" ");
      }
    }
    System.out.println(sb.toString());
  }

  private static int dijkstra(int sour, int dest) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    List<Integer> path = new ArrayList<>();
    path.add(sour);
    pq.add(new Node(sour, 0, path));
    valueMap[sour] = 0;
    visited[sour] = true;

    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      List<Node> nextList = map.get(cur.end);
      visited[cur.end] = true;
      List<Integer> curPath = new ArrayList<>(cur.path);
      if (valueMap[cur.end] < cur.value) {
        continue;
      }

      for (Node next : nextList) {
        List<Integer> newPath = new ArrayList<>(curPath);
        if (!visited[next.end] && valueMap[next.end] > cur.value + next.value) {
          valueMap[next.end] = cur.value + next.value;
          newPath.add(next.end);
          pathMap.set(next.end, newPath);
          pq.add(new Node(next.end, cur.value + next.value, newPath));
        }
      }
    }
    return valueMap[dest];
  }
}
