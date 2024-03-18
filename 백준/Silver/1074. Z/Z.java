import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]); // 총 4^N 칸
        int r = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);

        int n = (int) Math.sqrt(Math.pow(4, N)); // 한 변에 몇 칸.
        int cnt=0;

        while(n>1){
            n /= 2;
            int a = r/n; // 위, 아래
            int b = c/n; // 왼, 오

            if(a==0 && b==0){

            }else if(a==0 && b==1){
                cnt += n*n;
            }else if(a==1 && b==0){
                cnt += n*n*2;
            }else{
                cnt += n*n*3;
            }

            r %= n;
            c %= n;
        }

        System.out.println(cnt);
    }
}