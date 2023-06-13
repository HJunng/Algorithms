package Silver3;

import java.io.*;
public class BJ13305_주유소 { //55m. 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 도시 개수
		
		long dist[] = new long[n-1]; //연결하는 도로의 길이
		String str[] = br.readLine().split(" ");
		for(int i=0;i<n-1;i++)
			dist[i] = Integer.parseInt(str[i]);
		
		long cost[] = new long[n]; //도시 당 주유소 가격
		str = br.readLine().split(" ");
		for(int i=0;i<n;i++)
			cost[i] = Integer.parseInt(str[i]);
		
		long sum=dist[0]*cost[0]; // 무조건 제일 앞은 기름 넣어야함.
		long temp_cost=cost[0];
		for(int i=1;i<dist.length;i++) {
			
			if(cost[i]<temp_cost)
				temp_cost = cost[i];
			
			sum += dist[i] * temp_cost;
		}
		System.out.println(sum);
	}
}