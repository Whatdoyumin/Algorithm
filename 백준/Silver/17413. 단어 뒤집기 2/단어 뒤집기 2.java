
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String words = br.readLine();

    StringBuilder answer = new StringBuilder();
    StringBuilder temp = new StringBuilder();
    boolean isTag = false;

    for(int i = 0; i < words.length(); i++) {
      char c = words.charAt(i);

      if(c == '<') {
        answer.append(temp.reverse());
        temp.setLength(0);

        isTag = true;
        answer.append(c);

      } else if(c == '>') {
        isTag = false;
        answer.append(c);

      } else if(isTag) {
        // 태그 내용이니까 그냥 바로 answer에 넣기
        answer.append(c);

      } else {
        if(c == ' ') {
          answer.append(temp.reverse());
          answer.append(' ');
          temp.setLength(0);
        } else {
          temp.append(c);
        }
      }
    }

    answer.append(temp.reverse());

    System.out.println(answer);
  }
}
