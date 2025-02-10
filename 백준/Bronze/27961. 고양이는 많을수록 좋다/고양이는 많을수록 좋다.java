
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long cat = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        while (cat < N) {
            if (cat * 2 <= 1) {
                cat++;
            } else {
                cat = cat * 2;
            }
            count++;
        }
        System.out.println(count);
    }
}
