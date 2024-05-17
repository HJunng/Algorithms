import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int r = Integer.parseInt(br.readLine());

            int cnt=0;
            for(int i=-r;i<=r;i++){
                for(int j=-r;j<=r;j++){
                    double len = Math.sqrt(Math.pow(i,2)+Math.pow(j,2));

                    if(len<=r) cnt++;
                }
            }
            sb.append("#"+t+" "+cnt+"\n");
        }
        System.out.println(sb);
    }
}
