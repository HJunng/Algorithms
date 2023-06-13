package D2;

import java.io.*;
public class SWEA1959_두개의숫자열 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		String[] s;
		
		for(int t=1;t<=tc;t++) {
			s = br.readLine().split(" ");
			
			int n1 = Integer.parseInt(s[0]);
			int n2 = Integer.parseInt(s[1]);
			
			int[] a = new int[n1];
			int[] b = new int[n2];
			
			s=br.readLine().split(" ");
			for(int i=0;i<n1;i++)
				a[i]=Integer.parseInt(s[i]);
			
			s=br.readLine().split(" ");
			for(int i=0;i<n2;i++)
				b[i]=Integer.parseInt(s[i]);
			
			int max=Integer.MIN_VALUE;
			if(n1<=n2) {
				for(int i=0;i<=n2-n1;i++) {
					int sum=0;
					for(int j=0;j<n1;j++) {
						sum+=a[j]*b[i+j];
					}
					if(sum>max) max=sum;
				}
			}else {
				for(int i=0;i<=n1-n2;i++) {
					int sum=0;
					for(int j=0;j<n2;j++) {
						sum+=a[i+j]*b[j];
					}
					if(sum>max) max=sum;
				}
			}
			
			sb.append("#"+tc+" "+max+"\n");
		}
		System.out.println(sb);
	}
}