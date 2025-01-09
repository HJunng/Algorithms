import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        String[] s ;
        while(T-- >0) {
            s = br.readLine().split(" ");
            
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            
            int num = 1;
            for(int i=0;i<b;i++) {
                num *= a;
                num %= 10;
            }
            
            if(num==0) System.out.println(10);
            else System.out.println(num);
        }
    }
}