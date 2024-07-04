import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer,Integer> loc = new HashMap<>();
        for (int i = 0; i < n; i++) {
            loc.put(Integer.parseInt(br.readLine()), i);
        }

        int befLoc = loc.size(); // 가장 뒤
        int cnt = 0;
        for(int i=n;i>0;i--){
            int l = loc.get(i);

            if(befLoc > l) {
                befLoc = l;
                continue;
            }
            befLoc = 0;
            cnt++;
        }
        System.out.println(cnt);
    }
}