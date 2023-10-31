import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Bus implements Comparable<Bus> {
    int end;
    int charge;

    Bus(int end, int charge) {
        this.end = end;
        this.charge = charge;
    }

    @Override
    public int compareTo(Bus o) {
        return charge - o.charge;
    }

}
    
public class App {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Bus>> map = new ArrayList<>();
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            str = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(str.nextToken());
            int end = Integer.parseInt(str.nextToken());
            int charge = Integer.parseInt(str.nextToken());

            map.get(start).add(new Bus(end, charge));
        }
        str = new StringTokenizer(br.readLine());
        int sour = Integer.parseInt(str.nextToken());
        int dest = Integer.parseInt(str.nextToken());

        System.out.println(dijkstra(sour, dest, map, dist, visited));

    }

    static int dijkstra(int sour, int dest, ArrayList<ArrayList<Bus>> map, int[] dist, boolean[] visited) {
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(sour, 0));
        dist[sour] = 0;
        
        while (!pq.isEmpty()) {
            Bus currBus = pq.poll();
            int curr = currBus.end;

            if (!visited[curr]) {
                visited[curr] = true;
                for (Bus bus : map.get(curr)) {
                    if (!visited[bus.end] && dist[bus.end] > dist[curr] + bus.charge) {
                        dist[bus.end] = dist[curr] + bus.charge;
                        pq.add(new Bus(bus.end, dist[bus.end]));
                    }
                }
            }
        }

        return dist[dest];

    }

}
