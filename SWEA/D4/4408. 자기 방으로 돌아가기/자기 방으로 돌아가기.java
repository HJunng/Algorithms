import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int tc = Integer.parseInt(br.readLine());

        for(int t=1;t<=tc;t++){
            int n = Integer.parseInt(br.readLine());

            int[] room = new int[200];
            int max = 0;
            for(int i=0;i<n;i++){
                s = br.readLine().split(" ");

                int now = Integer.parseInt(s[0])-1;
                int go = Integer.parseInt(s[1])-1;

                if(now>go){
                    int temp = now;
                    now = go;
                    go = temp;
                }

                now/=2;
                go/=2;

                for(int j=now;j<=go;j++){
                    room[j]++;
                    max = Math.max(max,room[j]);
                }
            }
            sb.append("#"+t+" "+max+"\n");
        }
        System.out.println(sb);
    }
}
