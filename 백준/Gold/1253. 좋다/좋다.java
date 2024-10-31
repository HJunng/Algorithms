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

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);

        int cnt = 0;
        for(int i=0;i<n;i++){
            int left = 0;
            int right = n-1;

            while(left<right){
                if(left==i) {
                    left++; continue;
                }
                if(right==i) {
                    right--; continue;
                }

                if(arr[left]+arr[right]>arr[i]) right--;
                else if(arr[left]+arr[right]<arr[i]) left++;
                else {
                    cnt++; break;
                }
            }
        }
        System.out.println(cnt);
    }
}