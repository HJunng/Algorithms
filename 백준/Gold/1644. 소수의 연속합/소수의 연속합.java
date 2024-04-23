import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> prime = new ArrayList<>(); // 소수 구하기

        for(int i=2;i<=n;i++){
            boolean isPrime = true;
            for(int j=2;j*j<=i;j++){
                if(i%j==0) {
                    isPrime = false; break;
                }
            }
            if(isPrime) prime.add(i);
        }

        int sum = 0;
        Queue<Integer> sumQ = new LinkedList<>();
        int cnt=0;

        for(int i=0;i<prime.size();i++){
            sum += prime.get(i);
            sumQ.add(prime.get(i));

            while(sum>n){
                sum -= sumQ.poll();
            }

            if(sum==n){
                cnt++;
//                System.out.println(sumQ);
            }
        }

        System.out.println(cnt);

    }

}