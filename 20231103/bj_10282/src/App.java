import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Computer implements Comparable<Computer> {
  int next;
  int time;

  Computer(int next, int time) {
    this.next = next;
    this.time = time;
  }

  @Override
  public int compareTo(Computer o) {
    return time - o.time;
  }
}

public class App {

  static int n, d, c;
  static List<List<Computer>> map = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testCase = Integer.parseInt(br.readLine());

    for (int caseNum = 0; caseNum < testCase; caseNum++) {
      StringTokenizer str = new StringTokenizer(br.readLine());
      n = Integer.parseInt(str.nextToken());
      d = Integer.parseInt(str.nextToken());
      c = Integer.parseInt(str.nextToken());

      for (int i = 0; i <= n; i++) {
        map.add(new ArrayList<>());
      }

      for (int i = 0; i < d; i++) {
        str = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(str.nextToken());
        int b = Integer.parseInt(str.nextToken());
        int s = Integer.parseInt(str.nextToken());

        map.get(b).add(new Computer(a, s));
      }

      int[] resultMap = dijkstra(c);
      int cnt = 0;
      int time = 0;
      for (int i = 0; i < resultMap.length; i++) {
        if (resultMap[i] != Integer.MAX_VALUE) {
          cnt++;
          if (time < resultMap[i]) {
            time = resultMap[i];
          }
        }
      }
      System.out.println(cnt + " " + time);
      map.clear();
    }
  }

  private static int[] dijkstra(int start) {
    boolean[] visited = new boolean[n + 1];
    int[] valueMap = new int[n + 1];
    Arrays.fill(valueMap, Integer.MAX_VALUE);

    PriorityQueue<Computer> pq = new PriorityQueue<>();

    pq.add(new Computer(start, 0));
    valueMap[start] = 0;

    while (!pq.isEmpty()) {
      Computer cur = pq.poll();
      List<Computer> nextList = map.get(cur.next);

      if (!visited[cur.next]) {
        visited[cur.next] = true;
        for (Computer computer : nextList) {
          if (!visited[computer.next] && valueMap[computer.next] > valueMap[cur.next] + computer.time) {
            valueMap[computer.next] = valueMap[cur.next] + computer.time;
            pq.add(new Computer(computer.next, valueMap[computer.next]));
          }
        }
      }
    }
    return valueMap;
  }
}
