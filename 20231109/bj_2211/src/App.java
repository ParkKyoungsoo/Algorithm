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
  static int[][] resultMap;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(str.nextToken());
    M = Integer.parseInt(str.nextToken());
    valueMap = new int[N + 1];
    Arrays.fill(valueMap, Integer.MAX_VALUE);
    visited = new boolean[N + 1];
    resultMap = new int[N + 1][N + 1];
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

    dijkstra(1);

    int cnt = 0;
    for (int i = 0; i <= 1; i++) {
      for (int j = 0; j <= N; j++) {
        if (resultMap[i][j] != 0) {
          sb.append(resultMap[i][j] + " " + j + "\n");
          cnt++;
        }
      }
    }
    System.out.println(cnt);
    System.out.println(sb.toString());
  }

  private static void dijkstra(int start) {
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
            resultMap[start][next.end] = cur.end;
            pq.add(new Node(next.end, valueMap[next.end]));
          }
        }
      }
    }
  }
}
