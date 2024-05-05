import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;

        for(int tc=1;tc<=10;tc++){
            br.readLine();

            int[][] num = new int[100][100];
            int max=0;

            // 가로
            for(int i=0;i<100;i++){
                int sum=0;
                s = br.readLine().split(" ");
                for(int j=0;j<100;j++){
                    num[i][j] = Integer.parseInt(s[j]);
                    sum += num[i][j];
                }
                max = Math.max(max, sum);
            }

            // 세로
            for(int i=0;i<100;i++){
                int sum=0;
                for(int j=0;j<100;j++){
                    sum += num[j][i];
                }
                max = Math.max(max, sum);
            }

            int sum=0;
            for(int i=0;i<100;i++){
                sum += num[i][i];
            }
            max = Math.max(max,sum);

            sum=0;
            for(int i=0;i<100;i++){
                sum += num[99-i][i];
            }
            max = Math.max(max, sum);

            sb.append("#"+tc+" "+max+"\n");
        }
        System.out.println(sb);
    }
}
