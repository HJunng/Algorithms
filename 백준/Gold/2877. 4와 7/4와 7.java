import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextInt()-1;

        int i=0;
        for(i=1;Math.pow(2,i)<=k;i++){
            k-= (int)Math.pow(2,i);
        }

        // i는 자릿수, k는 그 자릿수에서 몇번째 숫자인지.
        StringBuilder sb  = new StringBuilder();
        for(int j=0;j<i;j++){
            sb.append(k%2);
            k /= 2;
        }

        String result = sb.reverse().toString();
        result = result.replace('0','4');
        result = result.replace('1','7');

        System.out.println(result);
    }
}