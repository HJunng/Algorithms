import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;

        for (int t = 1; t <= T; t++) {
            br.readLine();
            String find = br.readLine();
            String whole = br.readLine();

            int cnt=0;
            for(int i=0;i+find.length()<=whole.length();i++){
                if(find.equals(whole.substring(i,i+find.length()))){
                    cnt++;
                }
            }
            sb.append("#"+t+" "+cnt+"\n");
        }
        System.out.println(sb);
    }
}
