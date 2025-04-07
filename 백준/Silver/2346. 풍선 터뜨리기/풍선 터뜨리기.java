import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Balloon {
        int index;  // 풍선 번호
        int move;   // 이동 값

        Balloon(int index, int move) {
            this.index = index;
            this.move = move;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Balloon> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 풍선 정보 삽입
        for (int i = 1; i <= N; i++) {
            int move = Integer.parseInt(st.nextToken());
            deque.add(new Balloon(i, move));
        }

        StringBuilder sb = new StringBuilder();

        // 첫 풍선 터뜨리기
        Balloon current = deque.pollFirst();
        sb.append(current.index).append(" ");

        while (!deque.isEmpty()) {
            int steps = current.move;

            // 이동 방향이 양수면 오른쪽(앞에서 뺀 뒤로 넣음)
            if (steps > 0) {
                for (int i = 0; i < steps - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
                current = deque.pollFirst();
            }
            // 이동 방향이 음수면 왼쪽(뒤에서 뺀 걸 앞에 넣음)
            else {
                for (int i = 0; i < Math.abs(steps); i++) {
                    deque.addFirst(deque.pollLast());
                }
                current = deque.pollFirst();
            }

            sb.append(current.index).append(" ");
        }

        System.out.println(sb);
    }
}