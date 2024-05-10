import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            int n = Integer.parseInt(br.readLine());

            s = br.readLine().split(" ");

            int[] num = new int[n];
            for(int i=0;i<n;i++){
                num[i] = Integer.parseInt(s[i]);
            }

            int max = -1;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(isIncrease(String.valueOf(num[i]*num[j]))){
                        max = Math.max(max, num[i]*num[j]);
                    }
                }
            }
            sb.append("#"+t+" "+max+"\n");
        }
        System.out.println(sb);
    }
    static boolean isIncrease(String num){
        boolean flag = true;

        int bef = num.charAt(0)-'0';
        for(int i=1;i<num.length();i++){

            int now =  num.charAt(i)-'0';
            if(bef>now) {
                flag = false;
                break;
            }
            bef = now;
        }

        return flag;
    }
}
