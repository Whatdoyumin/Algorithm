import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cur = 1;
        boolean isPossible = true;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            while(cur <= num) {
                push(cur++);
            }

            if (stack.peek() == num) {
                pop();
            } else {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }

    private static void push(int num) {
        stack.push(num);
        sb.append("+").append("\n");
    }

    private static void pop() {
        stack.pop();
        sb.append("-").append("\n");
    }
}
