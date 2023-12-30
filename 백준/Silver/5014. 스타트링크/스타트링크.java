import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class Main {
 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
 
        int F = Integer.parseInt(str[0]);
        int S = Integer.parseInt(str[1]);
        int G = Integer.parseInt(str[2]);
        int U = Integer.parseInt(str[3]);
        int D = Integer.parseInt(str[4]);
        int[] arr = new int[F + 1];
        System.out.println(BFS(F, S, G, U, D, arr));
 
    }
 
    public static String BFS(int Floor, int start, int end, int up, int down, int[] arr) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        arr[start] = 1;
 
        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == end) {
                return String.valueOf(arr[current] - 1);
            }
            //다음 up 이동할 위치가 최대값보다 작고 방문하지 않은 지점이여야 한다.
            if (current + up <= Floor) {
                if (arr[current + up] == 0) {
                    arr[current + up] = arr[current] + 1;
                    q.add(current + up);
                }
 
            }
            //다음 down 이동할 위치가 최대값보다 작고 방문하지 않은 지점이여야 한다.
            if (current - down > 0) {
                if (arr[current - down] == 0) {
                    arr[current - down] = arr[current] + 1;
                    q.add(current - down);
                }
            }
 
        }
        return "use the stairs";
    }
}
