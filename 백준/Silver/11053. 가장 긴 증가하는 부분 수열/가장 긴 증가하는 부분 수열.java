import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];//주어진 수열
		int[] increase = new int[N];//증가하는 수열안 원소 개수.
		
		int max=0;
		String str[] = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(str[i]);
			increase[i]=1;
			
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i] && increase[i]<=increase[j])
					increase[i] = increase[j]+1;
			}
			if(increase[i]>max) max=increase[i];
		}
		System.out.println(max);
	}
}