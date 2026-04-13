import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    for(int i = 0; i < N; i++) {
      int n = Integer.parseInt(br.readLine());
      int sum = 1;
      Map<String, Integer> map = new HashMap<>();

      for(int j = 0; j < n; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        String type = st.nextToken();
        map.put(type, map.getOrDefault(type, 0) + 1);
      }

      for(Map.Entry<String, Integer> e : map.entrySet()) {
        sum *= (e.getValue() + 1);
      }

      System.out.println(sum - 1);
    }

  }
}
