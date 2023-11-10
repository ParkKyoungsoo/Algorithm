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
  static int n, m;
  static List<List<Node>> map = new ArrayList<>();
  static int[][] pathMap;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(br.readLine());
    n = Integer.parseInt(str.nextToken());
    m = Integer.parseInt(str.nextToken());

    for (int i = 0; i <= n; i++) {
      map.add(new ArrayList<>());
    }

    pathMap = new int[n][n];

    for (int i = 0; i < m; i++) {
      str = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(str.nextToken());
      int end = Integer.parseInt(str.nextToken());
      int value = Integer.parseInt(str.nextToken());
      map.get(start).add(new Node(end, value));
      map.get(end).add(new Node(start, value));
    }
    for (int i = 1; i <= n; i++) {
      dijkstra(i);
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          System.out.print("-" + " ");
        } else {
          System.out.print(pathMap[i][j] + " ");
        }
      }
      System.out.println();
    }
  }

  private static void dijkstra(int start) {
    int[] valueMap = new int[n + 1];
    boolean[] visited = new boolean[n + 1];
    Arrays.fill(valueMap, Integer.MAX_VALUE);

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));
    valueMap[start] = 0;

    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      List<Node> nextList = map.get(cur.end);
      if (valueMap[cur.end] < cur.value) {
        continue;
      }

      if (!visited[cur.end]) {
        visited[cur.end] = true;
        for (Node next : nextList) {
          if (valueMap[next.end] > valueMap[cur.end] + next.value) {
            valueMap[next.end] = valueMap[cur.end] + next.value;
            pathMap[next.end - 1][start - 1] = cur.end;
            pq.add(new Node(next.end, valueMap[next.end]));
          }
        }
      }
    }
    // System.out.println(pathMap.toString());

  }
}
