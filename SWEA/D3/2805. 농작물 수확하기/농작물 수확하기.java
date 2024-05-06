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
            long sum=0;
            int mid = n/2;

            for(int i=0;i<n;i++){
                s = br.readLine().split("");
                for(int j=0;j<n;j++){
                    if(Math.abs(i-mid)+Math.abs(j-mid) <= mid){
                        sum += Integer.parseInt(s[j]);
                    }
                }
            }

            sb.append("#"+t+" "+sum+"\n");
        }
        System.out.println(sb);
    }
}
