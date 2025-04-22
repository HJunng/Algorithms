import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, total;
	static int[] request;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 지방의 수, 10억 이하

		request = new int[N];

		int max = 1;
		String[] s = br.readLine().split(" ");
		for(int i = 0; i < N; i++){
			request[i] = Integer.parseInt(s[i]);
			max = Math.max(max, request[i]);
		}

		total = Integer.parseInt(br.readLine()); // 10억 이하

		int left = 1;
		int right = max;

		int maxTotal = N;
		int maxCost = (left+right)/2;
		while(left<=right){
			int mid = (left+right)/2;
			int tempTotal = calCost(mid);

			if(tempTotal<=total){
				maxTotal = tempTotal;
				maxCost = mid;
				left = mid+1;
			} else {
				right = mid-1;
			}
		}

		System.out.println(maxCost);
	}

	static int calCost(int max) {
		int sum=0;
		for(int i=0;i<N;i++){
			if(request[i]<=max) sum+=request[i];
			else sum+=max;
		}
		return sum;
	}
}