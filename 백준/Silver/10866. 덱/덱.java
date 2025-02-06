import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> d = new ArrayDeque<>();
        String[] str;

        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            switch (str[0]) {
                case "push_front" -> d.addFirst(Integer.parseInt(str[1]));
                case "push_back" -> d.addLast(Integer.parseInt(str[1]));
                case "pop_front" -> sb.append(d.isEmpty() ? -1 : d.pollFirst()).append("\n");
                case "pop_back" -> sb.append(d.isEmpty() ? -1 : d.pollLast()).append("\n");
                case "size" -> sb.append(d.size()).append("\n");
                case "empty" -> sb.append(d.isEmpty() ? 1 : 0).append("\n");
                case "front" -> sb.append(d.isEmpty() ? -1 : d.peekFirst()).append("\n");
                case "back" -> sb.append(d.isEmpty() ? -1 : d.peekLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}