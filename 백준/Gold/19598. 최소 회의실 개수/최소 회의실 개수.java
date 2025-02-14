import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Queue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        Node[] meeting = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            meeting[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meeting);

        pq.offer(meeting[0].end);

        for (int i = 1; i < N; i++) {
            if (meeting[i].start >= pq.peek()) {
                pq.poll();
            }

            pq.offer(meeting[i].end);
        }

        System.out.println(pq.size());
    }
}

class Node implements Comparable<Node>{
    int start, end;

    public Node (int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Node next) {
        if (this.start == next.start) {
            return this.end - next.end;
        }
        else {
            return this.start - next.start;
        }
    }
}