import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int max = 0;
    static int[] nums;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        nums = new int[N];
        visit = new boolean[N];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }

        maxCollection(0,N,new int[N]);

        System.out.println(max);
    }
    static void maxCollection(int idx, int maxIdx, int[] arr) {
        if(idx == maxIdx){
            max = Math.max(max, calculate(arr));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!visit[i]){
                visit[i] = true;
                arr[idx] = nums[i];
                maxCollection(idx+1, maxIdx, arr);
                visit[i] = false;
            }
        }
    }
    static int calculate(int[] arr){
        int sum = 0;
        for(int i=0;i<arr.length-1;i++){
            sum += Math.abs(arr[i]-arr[i+1]);
        }
        return sum;
    }
}