import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] s = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;

        int closeZero = Integer.MAX_VALUE; // 두 수의 차이
        int closeLeft = 0;
        int closeRight = arr.length-1;
        while(left<right) {
            int sum = arr[left] + arr[right];

            if(sum==0){
                closeZero = 0;
                closeLeft = left; closeRight = right;
                break;
            } else if(sum<0) {
                if(-sum < closeZero) {
                    closeZero = -sum;
                    closeLeft = left; closeRight = right;
                }
                left++;
            } else {
                if(sum < closeZero) {
                    closeZero = sum;
                    closeLeft = left; closeRight = right;
                }
                right--;
            }
        }

        System.out.println(arr[closeLeft]+" "+arr[closeRight]);
    }
}