https://orange-noodle.tistory.com/29

```
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class App {
    static int N;
    static int Q;
    static List<List<int[]>> usadoMap = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(str.nextToken());
        Q = Integer.parseInt(str.nextToken());

        for (int i = 0; i <= N; i++) {
            usadoMap.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            str = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(str.nextToken());
            int end = Integer.parseInt(str.nextToken());
            int usado = Integer.parseInt(str.nextToken());
            usadoMap.get(start).add(new int[] { end, usado });
            usadoMap.get(end).add(new int[] { start, usado });
        }

        for (int i = 0; i < Q; i++) {
            str = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(str.nextToken());
            int V = Integer.parseInt(str.nextToken());
            sb.append(BFS(K, V)).append("\n");
        }
        System.out.println(sb.toString());

    }

    public static int BFS(int k, int v) {
        int usado = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        boolean visited[] = new boolean[N + 1];

        visited[v] = true;
        pq.add(new int[] { v, 0 });
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            List<int[]> video = usadoMap.get(cur[0]);
            for (int[] arr : video) {
                if (visited[arr[0]]) {
                    continue;
                }
                if (arr[1] >= k) {
                    usado++;
                    visited[arr[0]] = true;
                    pq.add(arr);
                }
            }
        }

        return usado;
    }
}
```
