package Gold4;

import java.io.*;
public class BJ11054_가장긴바이토닉부분수열_2 { //10m.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][3];
		//[0] 주어진수 / [1] 자기 앞 바이토닉수열 / [2] 뒤 바이토닉수열
		String str[] = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			arr[i][0] = Integer.parseInt(str[i]);
			
			for(int j=0;j<i;j++)//앞부분 바이토닉 수열
				if(arr[j][0]<arr[i][0])
					arr[i][1]=Math.max(arr[i][1], arr[j][1]+1);
		}
		int result=0;
		for(int i=n-1;i>=0;i--){
			for(int j=n-1;j>i;j--) {
				if(arr[j][0]<arr[i][0])
					arr[i][2]=Math.max(arr[i][2], arr[j][2]+1);
			}
			if(arr[i][1]+arr[i][2] > result) result=arr[i][1]+arr[i][2];
		}
		System.out.println(result+1);
	}
}