import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        TreeSet<Integer> ts = new TreeSet<>();
        for(int i=1;i<=G;i++){
            ts.add(i);
        }

        int cnt=0;
        for(int i=0;i<P;i++){
//            System.out.println(ts);
            int plane = Integer.parseInt(br.readLine());
            Integer gate = ts.floor(plane);

            if(gate==null) break;
            else {
                cnt++;
                ts.remove(gate);
            }
        }
        System.out.println(cnt);
    }

}