import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.startsWith("push_front")) {
                int num = Integer.parseInt(command.split(" ")[1]);
                pushFront(num);
            } else if (command.startsWith("push_back")) {
                int num = Integer.parseInt(command.split(" ")[1]);
                pushBack(num);
            } else if (command.equals("pop_front")) {
                sb.append(popFront()).append("\n");
            } else if (command.equals("pop_back")) {
                sb.append(popBack()).append("\n");
            } else if (command.equals("size")) {
                sb.append(size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(empty()).append("\n");
            } else if (command.equals("front")) {
                sb.append(front()).append("\n");
            } else if (command.equals("back")) {
                sb.append(back()).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static void pushFront(int num) {
        deque.addFirst(num);
    }

    private static void pushBack(int num) {
        deque.addLast(num);
    }

    private static int popFront() {
        if (deque.isEmpty()) return -1;
        return deque.pollFirst();
    }

    private static int popBack() {
        if (deque.isEmpty()) return -1;
        return deque.pollLast();
    }

    private static int size() {
        return deque.size();
    }

    private static int empty() {
        return deque.isEmpty() ? 1 : 0;
    }

    private static int front() {
        if (deque.isEmpty()) return -1;
        return deque.peekFirst();
    }

    private static int back() {
        if (deque.isEmpty()) return -1;
        return deque.peekLast();
    }
}