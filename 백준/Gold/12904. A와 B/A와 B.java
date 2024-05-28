import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        Queue<String> q = new LinkedList<>();
        q.add(S);

        boolean flag = false;
        while(!q.isEmpty()){
            String now = q.poll();

            if(now.equals(T)){
                flag = true; break;
            }

            if(now.length()<T.length()){
                StringBuilder sb = new StringBuilder(now).reverse();
                
                if(T.contains(now+"A") || T.contains("A"+sb)){
                    q.add(now+"A");
                }
                
                if(T.contains("B"+now) || T.contains(sb+"B")){
                    q.add(sb+"B");
                }
            }
        }
        if(flag) System.out.println(1);
        else System.out.println(0);
    }
}