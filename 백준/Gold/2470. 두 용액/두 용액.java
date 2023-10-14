import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] s = br.readLine().split(" ");
		int[] arr = new int[N];
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(s[i]);
		
		Arrays.sort(arr); // 오름차순 정렬.
		
		int[] answer = new int[2];
		int min = Integer.MAX_VALUE;
		
		int left=0, right=N-1;
		while(left!=right) {
			
			int sum = arr[left] + arr[right];
			int absSum = Math.abs(sum);
			
			if(absSum<min) {
				answer[0] = arr[left];
				answer[1] = arr[right];
				min = absSum;
			}
			
			if(sum<0) {
				left++;
			}else {
				right--;
			}
		}
		
		System.out.println(answer[0]+" "+answer[1]);
	}
}