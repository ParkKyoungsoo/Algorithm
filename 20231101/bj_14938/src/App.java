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
  // n: 지역 개수
  // m: 수색범위
  // r: 길의 개수
  static int n, m, r;
  static List<List<Node>> map = new ArrayList<>();
  static boolean[] visited;
  static int[] valueMap;
  static int[] itemMap;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(br.readLine());

    int result = Integer.MIN_VALUE;
    n = Integer.parseInt(str.nextToken());
    m = Integer.parseInt(str.nextToken());
    r = Integer.parseInt(str.nextToken());

    itemMap = new int[n + 1];
    str = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      itemMap[i] = Integer.parseInt(str.nextToken());
    }

    for (int i = 0; i <= n; i++) {
      map.add(new ArrayList<>());
    }

    for (int i = 0; i < r; i++) {
      str = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(str.nextToken());
      int end = Integer.parseInt(str.nextToken());
      int value = Integer.parseInt(str.nextToken());
      map.get(start).add(new Node(end, value));
      map.get(end).add(new Node(start, value));

    }

    for (int i = 1; i <= n; i++) {
      result = Math.max(dijkstra(i, m), result);
    }

    System.out.println(result);

  }

  private static int dijkstra(int start, int limit) {
    int itemCnt = itemMap[start];
    visited = new boolean[n + 1];
    valueMap = new int[n + 1];
    Arrays.fill(valueMap, Integer.MAX_VALUE);
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));
    visited[start] = true;

    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      List<Node> nextList = map.get(cur.end);

      for (Node next : nextList) {
        if (visited[next.end]) {
          continue;
        }

        if (valueMap[next.end] > cur.value + next.value) {
          if (cur.value + next.value > m) {
            continue;
          }
          visited[next.end] = true;
          valueMap[next.end] = cur.value + next.value;
          pq.add(new Node(next.end, cur.value + next.value));
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      if (valueMap[i] == Integer.MAX_VALUE) {
        continue;
      }
      itemCnt += itemMap[i];
    }
    return itemCnt;
  }
}
