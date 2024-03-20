import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while(tc-->0){
            String[] s = br.readLine().split(" ");

            int n = Integer.parseInt(s[0]); //국가의 수
            int m = Integer.parseInt(s[1]); //비행기 종류

            for(int i=0;i<m;i++) br.readLine();

            System.out.println(n-1);
        }
    }
}