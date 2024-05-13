import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String original = br.readLine();

            int cnt = 0;
            char now = '0';
            for(int i=0;i<original.length();i++){
                if(original.charAt(i) != now){
                    cnt++;
                    now = original.charAt(i);
                }
            }
            sb.append("#"+t+" "+cnt+"\n");
        }
        System.out.println(sb);
    }
}
