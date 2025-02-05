
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static char[] arr;
    static boolean[] visited = new boolean[10];
    static String max = "", min = "";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new char[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            dfs(i, 0, i + "");
            visited[i] = false;
        }

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int now, int count, String num) {
        if (count == k) {
            if (max.equals("") || num.compareTo(max) > 0) max = num;
            if (min.equals("") || num.compareTo(min) < 0) min = num;
            return;
        }

        for (int next = 0; next < 10; next++) {
            if (!visited[next]) {
                if ((arr[count] == '<' && now < next) || (arr[count] == '>' && now > next)) {
                    visited[next] = true;
                    dfs(next, count + 1, num + next);
                    visited[next] = false;
                }
            }
        }
    }
}
