import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a,1});

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0]==b) {
                System.out.println(now[1]);
                return;
            }

            if(now[0]<=Integer.MAX_VALUE/2 && now[0]*2 <= b) {
                q.add(new int[]{now[0]*2,now[1]+1});
            }
            if(now[0]<= (Integer.MAX_VALUE-1)/10 && now[0]*10+1 <= b) {
                q.add(new int[]{now[0]*10+1,now[1]+1});
            }
        }
        System.out.println(-1);
    }
}