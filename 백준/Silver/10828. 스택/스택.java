import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack = new Stack<>();

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
            } else if (text.equals("top")) {
                sb.append(top()).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static void push(int num) {
        stack.push(num);
    }

    private static int pop() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            return stack.pop();
        }
    }

    private static int size() {
        return stack.size();
    }

    private static int empty() {
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    private static int top() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            return stack.peek();
        }
    }
}
