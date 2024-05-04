import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static int max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] s;

        for(int t=1;t<=tc;t++){
            s = br.readLine().split(" ");
            StringBuilder num = new StringBuilder(s[0]);
            int cnt = Integer.parseInt(s[1]);
            max=0;
            
            // 시간 초과 최적화 : swap 횟수가 자릿수보다 클 때 자릿수만큼만 옮겨도 모든 경우 가능.
            cnt = Math.min(num.length(), cnt);
            dfs(num, cnt);

            sb.append("#"+t+" "+max+"\n");
        }
        System.out.println(sb);
    }
    static void dfs(StringBuilder num, int cnt){
        if(cnt==0){
            max = Math.max(max, Integer.parseInt(num.toString()));
            return;
        }

        for(int i=0;i<num.length();i++){
            for(int j=i+1;j<num.length();j++){
                char a = num.charAt(i);
                num.setCharAt(i,num.charAt(j));
                num.setCharAt(j,a);

                dfs(num, cnt-1);

                num.setCharAt(j,num.charAt(i));
                num.setCharAt(i,a);
            }
        }
    }
}
