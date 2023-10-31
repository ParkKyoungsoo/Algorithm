import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {

    int end;
    int fee;

    Node(int end, int fee) {
        this.end = end;
        this.fee = fee;
    }

    @Override
    public int compareTo(Node o) {
        return fee - o.fee;
    }

    
}

public class App {
    static int N, M;
    static List<List<Node>> busMap = new ArrayList<>();
    static boolean[] visited;
    static int minValue = Integer.MAX_VALUE;
    static int[] feeMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        feeMap = new int[N + 1];
        Arrays.fill(feeMap, Integer.MAX_VALUE);
        
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            busMap.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(str.nextToken());
            int end = Integer.parseInt(str.nextToken());
            int fee = Integer.parseInt(str.nextToken());
            busMap.get(start).add(new Node(end, fee));
        }

        str = new StringTokenizer(br.readLine());
        int sour = Integer.parseInt(str.nextToken());
        int dest = Integer.parseInt(str.nextToken());

        checkFee(sour, dest);
        
        System.out.println(feeMap[dest]);
    }

    private static void checkFee(int sour, int dest) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(sour, 0));
        feeMap[sour] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            List<Node> nextList = busMap.get(cur.end);
            if (!visited[cur.end]) {
                visited[cur.end] = true;
                for (Node next : nextList) {
                    if (visited[next.end]) {
                        continue;
                    }
        
                    if (feeMap[next.end] > feeMap[cur.end] + next.fee) {
                        feeMap[next.end] = feeMap[cur.end] + next.fee;
                        pq.add(new Node(next.end, feeMap[next.end]));
                    }
                }
            }
        }
    }
}
