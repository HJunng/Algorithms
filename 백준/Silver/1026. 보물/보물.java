import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] A = new Integer[n];
        Integer[] B = new Integer[n];

        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");

        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(a[i]);
            B[i] = Integer.parseInt(b[i]);
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int answer = 0;
        for(int i=0;i<n;i++){
            answer += A[i]*B[i];
        }
        System.out.println(answer);
    }
}
