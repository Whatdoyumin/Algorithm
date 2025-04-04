import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static Queue<Integer> queue = new LinkedList<>();
    static int last = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String text = br.readLine();

            if (text.startsWith("push")) {
                int n = Integer.parseInt(text.split(" ")[1]);
                push(n);
            } else if(text.equals("pop")) {
                sb.append(pop()).append("\n");
            } else if (text.equals("size")) {
                sb.append(size()).append("\n");
            } else if (text.equals("empty")) {
                sb.append(empty()).append("\n");
            } else if (text.equals("front")) {
                sb.append(front()).append("\n");
            } else if (text.equals("back")) {
                sb.append(back()).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static void push(int num) {
        queue.add(num);
        last = num;
    }

    private static int pop() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            int q = queue.poll();
            if (queue.isEmpty()) {
                last = -1;
            }
            return q;
        }
    }

    private static int size() {
        return queue.size();
    }

    private static int empty() {
        if (queue.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    private static int front() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            return queue.peek();
        }
    }

    private static int back() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            return last;
        }
    }
}
