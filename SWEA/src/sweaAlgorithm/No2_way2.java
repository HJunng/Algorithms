package sweaAlgorithm;

import java.io.*;

public class No2_way2 {
	static int x;
	static int y;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		int T = Integer.parseInt(str[0]);
		
		for(int k=1;k<=T;k++) {
			str = br.readLine().split(" ");
			
			String N = str[0];
			int n = Integer.parseInt(N);
			x = Integer.parseInt(str[1]);
			y = Integer.parseInt(str[2]);
			
			int temp=0;
			int result=-1;
			
			if(x!=0 && x>n) {
				System.out.println("#"+k+" "+result);
			}else if(x==0 && y>n) {
				System.out.println("#"+k+" "+result);
			}else {
				result=0;
				for(int i=0;i<N.length();i++) {
					char c = N.charAt(i);
					temp = temp*10 + Integer.parseInt(String.valueOf(c));
					if((temp/y)>=1) {
						result = result*10 + y;
						temp-=y;
					}else if((temp/x)>=1) {
						result = result*10 + x;
						temp-=x;
					}
				}
				System.out.println("#"+k+" "+result);
			}
		}
	}

}
