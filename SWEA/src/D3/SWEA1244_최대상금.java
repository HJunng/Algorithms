package D3;

import java.io.*;

public class SWEA1244_최대상금 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		String[] s;

		for(int t=1;t<=tc;t++) {
			s = br.readLine().split(" ");
			
			StringBuilder num = new StringBuilder(s[0]);
			int cnt=Integer.parseInt(s[1]);
			
			for(int i=0;i<num.length();i++) {
				if(cnt==0) break;
				
				//맨마지막 두자리는 cnt만큼 계속 자리 바꿔줌.
				if(num.length()-i==2) {
					//홀수번이면 자리 바꾸고, 짝수번이면 그대로 출력.
					if(cnt%2==1) {
						char temp = num.charAt(i);
						num.setCharAt(i, num.charAt(i+1));
						num.setCharAt(i+1, temp);
					}
					break;
				}
				
				//세자리 이상 남았을 경우.
				else {
					//가장 큰 값을 맨 앞자리로 오게 하기 위해 자리 바꿈.
					int max=num.charAt(i);
					int maxIndex=i;
					for(int j=i+1;j<num.length();j++) {
						if(num.charAt(j) >= max) {
							max=num.charAt(j);
							maxIndex=j;
						}
					}
					//제일 앞자리수가 제일 크면 그대로 두고 다음 반복문 실행.
					if(maxIndex==i) continue;
					
					//자리 바꾸고 다음 반복문 실행.
					char temp=num.charAt(i);
					num.setCharAt(i, num.charAt(maxIndex));
					num.setCharAt(maxIndex, temp);
					cnt--;
				}
			}
			System.out.println("#"+t+" "+num);
		}
	}

}
