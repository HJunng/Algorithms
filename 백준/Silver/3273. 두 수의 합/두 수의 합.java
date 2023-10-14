import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		String[] s = br.readLine().split(" ");
		for(int i=0;i<n;i++) arr[i] = Integer.parseInt(s[i]);
		
		Arrays.sort(arr); // 오름차순 정렬.
		
		int sum = Integer.parseInt(br.readLine());
		
		int answer=0;
		int left=0,right=n-1;
		while(true) {
			if(left==right) {
				break;
			}
			
			if(arr[left]+arr[right]==sum) answer++;
			if(arr[left]+arr[right]<sum) {
				left++;
			}else {
				right--;
			}
		}
		
		System.out.println(answer);
	}
}