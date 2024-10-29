import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] s = br.readLine().split(" ");

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        List<Integer> LIS = new ArrayList<Integer>();
        LIS.add(arr[0]);
        
        for(int i=1;i<n;i++){
            // 현재 숫자가 마지막 숫자 보다 작으면
            if(arr[i] > LIS.get(LIS.size()-1))
                LIS.add(arr[i]);
            else {
                int left = 0;
                int right = LIS.size()-1;
                while(left < right){
                    int mid = (left + right)/2;
                    if(LIS.get(mid) >= arr[i]){
                        right = mid;
                    } else {
                        left = mid+1;
                    }
                }
                // 리스트 안에서 자신보다 크지만 그중에 작은 수를 찾아서, 나로 대체
                LIS.set(right, arr[i]);
            }
        }
        System.out.println(LIS.size());
    }
}