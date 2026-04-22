import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int answer = 0;
        
        // target에서 켜져있는 비트(1)의 개수 계산
        for(int i = 0; i < 7; i++) {
            if ((target & (1 << i)) != 0) answer++;
        }
        
        System.out.println(answer);
    }
}
