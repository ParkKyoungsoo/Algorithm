import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class App {

  static class Node implements Comparable<Node> {
    int end;
    int time;

    Node(int end, int time) {
      this.end = end;
      this.time = time;
    }

    @Override
    public int compareTo(Node o) {
      return time - o.time;
    }

  }

  static int N, M, X;
  static int maxValue = Integer.MIN_VALUE;
  static List<List<Node>> map = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(br.readLine());

    N = Integer.parseInt(str.nextToken());
    M = Integer.parseInt(str.nextToken());
    X = Integer.parseInt(str.nextToken());
    int[] totalTime = new int[N + 1];

    for (int i = 0; i <= N; i++) {
      map.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      str = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(str.nextToken());
      int end = Integer.parseInt(str.nextToken());
      int time = Integer.parseInt(str.nextToken());
      map.get(start).add(new Node(end, time));
    }

    for (int i = 1; i <= N; i++) {
      if (i == X) {
        continue;
      }

      totalTime[i] = dijkstra(i)[X];
    }
    int[] toGoHomeTime = new int[N + 1];
    toGoHomeTime = toGoHome(X);

    for (int i = 1; i < totalTime.length; i++) {
      maxValue = Math.max(maxValue, totalTime[i] + toGoHomeTime[i]);
    }

    System.out.println(maxValue);

  }

  private static int[] toGoHome(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));

    int[] toHome = new int[N + 1];
    boolean[] toHomeVisited = new boolean[N + 1];
    Arrays.fill(toHome, Integer.MAX_VALUE);
    toHome[0] = start;
    toHome[start] = 0;

    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      List<Node> nextList = map.get(cur.end);
      if (!toHomeVisited[cur.end]) {
        toHomeVisited[cur.end] = true;
        for (Node next : nextList) {
          if (toHome[next.end] > toHome[cur.end] + next.time) {
            toHome[next.end] = toHome[cur.end] + next.time;
            pq.add(new Node(next.end, toHome[next.end]));
          }
        }
      }
    }

    return toHome;
  }

  private static int[] dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));

    int[] toParty = new int[N + 1];
    boolean[] toPartyVisited = new boolean[N + 1];
    Arrays.fill(toParty, Integer.MAX_VALUE);
    toParty[0] = start;
    toParty[start] = 0;

    // 목적지 까지 가는 최소비용
    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      List<Node> nextList = map.get(cur.end);
      if (!toPartyVisited[cur.end]) {
        toPartyVisited[cur.end] = true;
        for (Node next : nextList) {
          if (toParty[next.end] > toParty[cur.end] + next.time) {
            toParty[next.end] = toParty[cur.end] + next.time;
            pq.add(new Node(next.end, toParty[next.end]));
          }
        }
      }
    }

    return toParty;

  }
}
