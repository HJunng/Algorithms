package Silver1;

import java.util.Scanner;
public class BJ2156_포도주시식 {	//34min.참고.
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n+1];
		int sum[] = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			//if(i==n) arr[n]=0;	//맨마지막을 0이라고 놓고 마지막 수는 무조건 밟아야한다고 봄.
			//else arr[i]=s.nextInt(); //n-1까지 입력받음.
			arr[i] = s.nextInt();
			
			if(i==1) {
				sum[i] = arr[i];
			}else if(i==2) {
				sum[i] = arr[i-1]+arr[i];
			}else {	//i>=3								//0번째가 없으면 i-3배열 호출할 때 오류남.(런타임에러)
				sum[i] = Math.max(sum[i-1], Math.max(sum[i-2]+arr[i], sum[i-3]+arr[i-1]+arr[i]));
			}
		}
		System.out.println(sum[n]);	//맨 마지막 잔을 안먹을 수도 있음.
	}
}