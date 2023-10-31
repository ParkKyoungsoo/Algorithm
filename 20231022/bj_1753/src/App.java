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

    static int V, E, K;
    static List<List<Node>> map = new ArrayList<>();
    static int[] valueMap;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        V = Integer.parseInt(str.nextToken());
        E = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(br.readLine());
        valueMap = new int[V + 1];
        Arrays.fill(valueMap, Integer.MAX_VALUE);

        visited = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            str = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(str.nextToken());
            int end = Integer.parseInt(str.nextToken());
            int value = Integer.parseInt(str.nextToken());

            map.get(start).add(new Node(end, value));
        }

        dijkstra(K);
        for (int i = 1; i < valueMap.length; i++) {
            if (valueMap[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(valueMap[i]);
            }
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        valueMap[start] = 0;

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            List<Node> nextList = map.get(nowNode.end);

            if (!visited[nowNode.end]) {
                visited[nowNode.end] = true;
                for (Node nextNode : nextList) {
                    if (visited[nextNode.end]) {
                        continue;
                    }

                    if (valueMap[nextNode.end] > valueMap[nowNode.end] + nextNode.value) {
                        valueMap[nextNode.end] = valueMap[nowNode.end] + nextNode.value;
                        pq.add(new Node(nextNode.end, valueMap[nextNode.end]));
                    }
                }
            }

        }
    }
}
