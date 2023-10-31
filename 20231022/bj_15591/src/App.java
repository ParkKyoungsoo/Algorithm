import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class App {
    static int N, Q;
    static List<List<int[]>> videoRelation = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(str.nextToken());
        Q = Integer.parseInt(str.nextToken());

        for (int i = 0; i <= N; i++) {
            videoRelation.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            str = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(str.nextToken());
            int end = Integer.parseInt(str.nextToken());
            int usado = Integer.parseInt(str.nextToken());

            videoRelation.get(start).add(new int[] { end, usado });
            videoRelation.get(end).add(new int[] { start, usado });
        }

        for (int i = 0; i < Q; i++) {
            str = new StringTokenizer(br.readLine());
            // 연관지수
            int k = Integer.parseInt(str.nextToken());
            // 비디오 Number
            int v = Integer.parseInt(str.nextToken());
            sb.append(findVideo(k, v)).append("\n");

        }
        System.out.println(sb.toString());
    }

    public static int findVideo(int usado, int videoNum) {
        int videoCnt = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        boolean[] visited = new boolean[N + 1];
        visited[videoNum] = true;
        pq.add(new int[] { videoNum, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            List<int[]> curVideo = videoRelation.get(cur[0]);

            for (int[] nextVideo : curVideo) {
                if (visited[nextVideo[0]]) {
                    continue;
                }
                
                if (nextVideo[1] >= usado) {
                    videoCnt++;
                    visited[nextVideo[0]] = true;
                    pq.add(nextVideo);
                }
            }  
        }

        return videoCnt;
    }
}
