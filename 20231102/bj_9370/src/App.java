import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
  // n: 교차로 수 | m: 도로 수 | t: 목적지 수
  static int n, m, t;
  // s: 시작지점, | g, h: 해당 지점 사이의 교차로를 통과
  static int s, g, h;

  static List<List<Node>> map = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());

    for (int tc = 0; tc < testCase; tc++) {
      StringTokenizer str = new StringTokenizer(br.readLine());
      n = Integer.parseInt(str.nextToken());
      m = Integer.parseInt(str.nextToken());
      t = Integer.parseInt(str.nextToken());

      for (int i = 0; i <= n; i++) {
        map.add(new ArrayList<>());
      }

      str = new StringTokenizer(br.readLine());
      s = Integer.parseInt(str.nextToken());
      g = Integer.parseInt(str.nextToken());
      h = Integer.parseInt(str.nextToken());

      for (int i = 0; i < m; i++) {
        str = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(str.nextToken());
        int end = Integer.parseInt(str.nextToken());
        int value = Integer.parseInt(str.nextToken());
        map.get(start).add(new Node(end, value));
        map.get(end).add(new Node(start, value));
      }

      int[] dest = new int[t];
      for (int i = 0; i < t; i++) {
        dest[i] = Integer.parseInt(br.readLine());
      }

      // 시작점에서 모든 지점까지 최소거리
      int[] originValue = dijkstra(s);

      List<Integer> list = new ArrayList<>();
      int[] start_g = dijkstra(g);
      int[] start_h = dijkstra(h);

      for (int i = 0; i < t; i++) {
        int[] start_dest = dijkstra(dest[i]);
        int s_g = start_g[s];
        int g_h = start_h[g];
        // s -> g -> h -> t
        int h_t = start_dest[h];

        // s -> h -> g -> t
        int h_g = start_g[h];
        int s_h = start_h[s];
        int g_t = start_dest[g];
        int route_t = Math.min(s_g + g_h + h_t, s_h + h_g + g_t);

        if (originValue[dest[i]] >= route_t) {
          list.add(dest[i]);
        }
      }
      Collections.sort(list);
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < list.size(); i++) {
        sb.append(list.get(i) + " ");
      }
      System.out.println(sb.toString());
      sb.setLength(0);
      map.clear();
    }

  }

  private static int[] dijkstra(int start) {
    boolean[] visited = new boolean[n + 1];
    int[] valueMap = new int[n + 1];
    Arrays.fill(valueMap, Integer.MAX_VALUE);
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
            pq.add(new Node(next.end, valueMap[next.end]));
          }
        }
      }
    }
    return valueMap;
  }
}
