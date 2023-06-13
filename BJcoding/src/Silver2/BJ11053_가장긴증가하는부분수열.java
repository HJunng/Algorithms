package Silver2;

import java.io.*;
public class BJ11053_가장긴증가하는부분수열 {	//33min.답.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];//주어진 수열
		int[] increase = new int[N];//증가하는 수열안 원소 개수.
		
		int max=0;
		String str[] = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(str[i]);
			increase[i]=1;	//증가하는 수열에 나를 포함.
			
			for(int j=0;j<i;j++) {
				//앞에 있는 수 중에 i보다 작고, 증가하는 수열의 길이가 내거보다 길어야함.
				if(arr[j]<arr[i] && increase[i]<=increase[j])
					increase[i] = increase[j]+1;
			}
			//가장 긴 수열 길이 저장.
			if(increase[i]>max) max=increase[i];
		}
		System.out.println(max);
	}
}