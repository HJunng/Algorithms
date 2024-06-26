import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        long L = Long.parseLong(s[0]);
        long R = Long.parseLong(s[1]);

        int minCnt = String.valueOf(R).length();
        for(long i = L; i <= R; i++) {
            minCnt = Math.min(minCnt, countEight(i));

            if(minCnt==0) break;
        }
        System.out.println(minCnt);
    }
    static int countEight(long n){
        String num = String.valueOf(n);

        int count = 0;
        for(int i = 0; i < num.length(); i++){
            if(num.charAt(i) == '8') count++;
        }
        return count;
    }
}