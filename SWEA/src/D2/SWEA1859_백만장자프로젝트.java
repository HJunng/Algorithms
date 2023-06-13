package D2;

import java.io.*;
import java.util.*;
public class SWEA1859_백만장자프로젝트 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=tc;t++) {
			long sum=0; //!!!!꼭 long형으로 해야함!!
			Queue<Integer> q = new LinkedList<>();
			
			int N = Integer.parseInt(br.readLine());
			
			int[] price = new int[N];
			int max=0;
			
			String[] s = br.readLine().split(" ");
			for(int i=0;i<N;i++) {
				price[i] = Integer.parseInt(s[i]);
				
				if(price[i]>max) max=price[i];
			}
			for(int i=0;i<N;i++) {
				
				if(price[i]==max) {
					//여태까지 샀던것들 max값에 팔기
					while(q.size()>0) {
						sum+=max-q.poll();
					}
					//다음 max값 조사
					max=0;
					for(int j=i+1;j<N;j++) {
						if(price[j]>max) max=price[j];
					}
				}else
					q.add(price[i]);
			}
			
			System.out.println("#"+t+" "+sum);
		}
	}
}