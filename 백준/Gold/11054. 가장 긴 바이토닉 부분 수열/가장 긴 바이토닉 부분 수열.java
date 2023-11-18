import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		int dpLeft[] = new int[N];	//왼쪽 증가하는 수열 최대 개수
		int dpRight[] = new int[N]; //오른쪽 증가하는 수열 최대 개수
		
		String str[] = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(str[i]);
			
			for(int j=0;j<i;j++) {//왼쪽 증가하는 수열 최대 개수
				if(arr[j]<arr[i] && dpLeft[j]>=dpLeft[i])
				//자신보다 왼쪽에 있는 작은 수 && 증가하는 수열 개수가 내거보다 커야함.
					dpLeft[i]=dpLeft[j]+1;
			}
		}
		int max=0;//가장 긴수열 구하기
		for(int i=N-1;i>=0;i--) {
			for(int j=N-1;j>i;j--) {
				if(arr[j]<arr[i] && dpRight[j]>=dpRight[i])
					dpRight[i] = dpRight[j]+1;
			}
			if(dpLeft[i]+dpRight[i]+1 > max)
				max = dpLeft[i]+dpRight[i]+1;	//Sk인 자기자신 더해야 하므로 +1
		}
		System.out.println(max);
	}
}