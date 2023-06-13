package D3;

import java.io.*;

public class SWEA1493_수의새로운연산 { //25min.

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=tc;t++) {
			
			String[] s = br.readLine().split(" ");
			// p★q
			int p = Integer.parseInt(s[0]);
			int q = Integer.parseInt(s[1]);
			
			//x,y좌표
			int x=0;
			int y=0;
			
			//p 좌표구하기 | &p = (x,y)
			//같은 대각선에 있는 좌표는 x+y 값이 같음.
			int sum=2; //x+y
			while(p>=0) {
				if(p<sum) {
					x+=p;
					y+=sum-p;
					break;
				}
				else {
					p-=sum-1;
					sum++;
				}
			}
			
			//q 좌표 | &q = (x,y)
			sum=2;
			while(q>=0) {
				if(q<sum) {
					x+=q; //좌표 더함.
					y+=sum-q;
					break;
				}else {
					q-=sum-1;
					sum++;
				}
			}
			//System.out.println(x+" "+y);
			
			//두 좌표 합의 순서 구하기
			int cnt=0;
			sum=x+y;
			//x+y=i인 점의 개수 더함.
			for(int i=1;i<sum-1;i++) {
				cnt+=i;
			}
			cnt+=x;
			
			System.out.println("#"+t+" "+cnt);
		}
	}
}