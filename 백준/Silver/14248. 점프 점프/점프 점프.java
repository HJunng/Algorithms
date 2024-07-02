import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static boolean[] visit;
    static int[] move;
    static int visitCnt;
    static int n;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visit = new boolean[n];
        move = new int[n];
        String[] s = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            move[i] = Integer.parseInt(s[i]);
        }
        int start = Integer.parseInt(br.readLine())-1;
         visitCnt = 0;

         bfs(start);
         System.out.println(visitCnt);

    }
    static void bfs(int start){
        int[] dx = {-1,1};

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;
        visitCnt++;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i=0;i<2;i++){
                int next = now+dx[i]*move[now];
                if(next>=0 && next<n && !visit[next]){
                    visit[next] = true;
                    q.add(next);
                    visitCnt++;
                }
            }
        }
    }
}