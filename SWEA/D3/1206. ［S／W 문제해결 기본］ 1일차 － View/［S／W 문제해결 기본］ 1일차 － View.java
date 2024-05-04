import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s;

        for(int tc=1;tc<=10;tc++){
            int n = Integer.parseInt(br.readLine());
            s = br.readLine().split(" ");
            int[] height = new int[n];
            for(int i=0;i<n;i++)
                height[i] = Integer.parseInt(s[i]);

            int sum = 0;
            for(int i=2;i<n-2;i++){
                int left = Math.max(height[i-2], height[i-1]);
                int right = Math.max(height[i+1],height[i+2]);
                int max = Math.max(left,right);

                if(height[i]>max) sum+=height[i]-max;
            }

            System.out.println("#"+tc+" "+sum);
        }
    }
}
