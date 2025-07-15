
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String sound = br.readLine();
    int maxCount = 0;

    // 0: q, 1: u, 2: a, 3: c, 4: k
    List<Integer> duckState = new ArrayList<>();

    for(char c : sound.toCharArray()) {
      int step = "quack".indexOf(c);
      boolean assigned = false;

      for(int i = 0; i < duckState.size(); i++) {
        if(duckState.get(i) == step - 1) {
          duckState.set(i, step);
          if(step == 4) {
            duckState.set(i, -1);
          }
          assigned = true;
          break;
        }
      }

      if(!assigned) {
        if (step == 0) {
          duckState.add(0);
          maxCount = Math.max(maxCount, duckState.size());
        } else {
          System.out.println(-1);
          return;
        }
      }
    }

    for(int state : duckState) {
      if (state != -1) {
        System.out.println(-1);
        return;
      }
    }

    System.out.println(maxCount);
  }
}
