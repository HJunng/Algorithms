import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int T = 10;

        for (int t = 1; t <= T; t++) {
            s.next();

            int a = s.nextInt();
            int b = s.nextInt();
            int result = 1;
            
            for(int i=0;i<b;i++){
                result *= a;
            }

            System.out.println("#"+t+" "+result);
        }
    }
}
