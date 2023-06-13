package sweaAlgorithm;

import java.io.*;

public class No2_Way3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		int T = Integer.parseInt(str[0]);	//테스트케이스 수
		for(int k=1;k<=T;k++) {
			str = br.readLine().split(" ");
			
			String N = str[0];	//첫번째 자리부터 charAt으로 받아서 사용하려고 String 사용함.
			int n = Integer.parseInt(N);
			int x = Integer.parseInt(str[1]);
			int y = Integer.parseInt(str[2]);
			
			int result=-1;
			
			if((x!=0 && x>n) || (x==0 && y>n)) {
				System.out.println("#"+k+" "+result);
				continue;
			}else {
				System.out.print("#"+k+" ");
				result=0;
				boolean big=false;	//앞의 자리 수가 1이상 있으면 다음 수부터 일의자리까지는 모두 y 사용하면 됨.
				
				for(int i=0;i<N.length();i++) {//N의 자릿수만큼 반복.
					if(big) {
						System.out.print(y);
						continue;
					}
					else {
						int temp = Integer.parseInt(String.valueOf(N.charAt(i)));	//String의 i번째 문자 숫자로 바꾸기.
						if(temp<x) {
							big=true;
						}else if(temp>=y) {
							System.out.print(y);
							if(temp-y >0) big=true;
						}else {
							System.out.print(x);
							if(temp-x>0) big=true;
						}
					}
				}
				System.out.println();
			}
		}
	}
}
