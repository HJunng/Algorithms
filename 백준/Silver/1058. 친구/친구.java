import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, Set<Integer>> conn;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        conn = new HashMap<>();
        for (int i = 0; i < N; i++) {
            conn.put(i, new HashSet<>());
            String line = br.readLine();

            for(int j = 0; j < N; j++){
                if(line.charAt(j) == 'Y'){
                    conn.get(i).add(j);
                    if(!conn.containsKey(j)){
                        conn.put(j, new HashSet<>());
                    }
                    conn.get(j).add(i);
                }
            }
        }

//        System.out.println(conn);

        int maxCnt = 0;
        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            maxCnt = Math.max(maxCnt, cntFriends(i));
        }
        System.out.println(maxCnt);
    }
    static int cntFriends(int start){
        Queue<Integer> q = new LinkedList<>();
        visit[start] = true;

        int count = 0;
        for(int i : conn.get(start)){
            visit[i] = true;
            count++;
            q.add(i);
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i : conn.get(cur)){
                if(!visit[i]){
                    visit[i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}