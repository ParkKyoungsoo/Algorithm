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
  // N 도시개수
  // M 도로개수
  // K 거리정보
  // X 출발도시정보

  static int N, M, K, X;
  static List<List<Node>> map = new ArrayList<>();
  static int[] valueMap;
  static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(br.readLine());

    N = Integer.parseInt(str.nextToken());
    M = Integer.parseInt(str.nextToken());
    K = Integer.parseInt(str.nextToken());
    X = Integer.parseInt(str.nextToken());

    for (int i = 0; i <= N; i++) {
      map.add(i, new ArrayList<>());
    }

    valueMap = new int[N + 1];
    visited = new boolean[N + 1];
    Arrays.fill(valueMap, Integer.MAX_VALUE);

    for (int i = 0; i < M; i++) {
      str = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(str.nextToken());
      int end = Integer.parseInt(str.nextToken());
      int value = 1;
      map.get(start).add(new Node(end, value));
    }

    dijkstra(X, K);

    List<Integer> result = new ArrayList<>();
    for (int i = 1; i < valueMap.length; i++) {
      if (valueMap[i] == K) {
        result.add(i);
      }
    }

    if (result.size() == 0) {
      System.out.println(-1);
    } else {
      for (int i = 0; i < result.size(); i++) {
        System.out.println(result.get(i));
      }
    }
  }

  private static void dijkstra(int start, int value) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));
    valueMap[start] = 0;
    visited[start] = true;

    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      List<Node> nextList = map.get(cur.end);

      for (Node next : nextList) {
        if (!visited[next.end]) {
          visited[next.end] = true;
          if (valueMap[next.end] > valueMap[cur.end] + next.value) {
            valueMap[next.end] = valueMap[cur.end] + next.value;
            pq.add(new Node(next.end, valueMap[cur.end] + next.value));
          }
        }
      }
    }
  }
}
