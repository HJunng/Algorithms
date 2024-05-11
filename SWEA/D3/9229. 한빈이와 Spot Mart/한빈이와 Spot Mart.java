import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            s = br.readLine().split(" ");

            int n = Integer.parseInt(s[0]); // 과자 개수
            int m = Integer.parseInt(s[1]); // 무게 합 제한

            int[] w = new int[n];
            s = br.readLine().split(" ");
            for(int i=0;i<n;i++){
                w[i] = Integer.parseInt(s[i]);
            }
            Arrays.sort(w);

            if(m<w[0]+w[1]){
                sb.append("#"+t+" -1\n");
                continue;
            }

            int left=0, right=n-1;
            int max=-1;
            while(left<right){
                if(w[left]+w[right]<=m){
                    max = Math.max(max, w[left]+w[right]);
                    left++;
                } else {
                    right--;
                }
            }
            sb.append("#"+t+" "+max+"\n");
        }
        System.out.println(sb);
    }
}