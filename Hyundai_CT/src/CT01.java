import java.io.*;
class CT01 {
	
	static int check_all(int a[][]) {	//배열 안의 수가 같으면 1출력
		if(a[0].length==1)	return 1;	//배열 안의 원소가 1개인 경우
		
		int t1=a[0][0];
		int t2 = a[0][0];
		
		for(int i=0;i<a[0].length;i++) {
			for(int j=0;j<a[0].length;j++) {
				t2 = a[i][j];
				if(t1!=t2)	break;	
			}
			if(t1!=t2)	break;	
		}
		
		if(t1==t2)	return 1;
		else	return 0;
	}
	
	static void go(int a[][]) {
		int n = a[0].length;
		if(n==1) {	
			System.out.print(a[0][0]);
			return;
		}
		int check = check_all(a);
		if(check==1){	
			System.out.print(a[0][0]);
			return;
		}
		else {
			System.out.println();
			System.out.print("(");	//4분할 하면 (로 시작.
			n=n/2;
			
			int b[][] = new int [n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					b[i][j] = a[i][j];
				}
			}
			go(b);	//재귀
			
			int c[][] = new int [n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					c[i][j] = a[i][n+j];
				}
			}
			go(c);
			
			int d[][] = new int [n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					d[i][j] = a[n+i][j];
				}
			}
			go(d);
			
			int e[][] = new int [n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					b[i][j] = a[n+i][n+j];
				}
			}
			go(e);
			System.out.print(")");	//왜 재귀함수 마지막게 제대로 안나오고 재귀 잘 안됨.
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split("");
		int N = Integer.parseInt(input[0]);
		int a[][] = new int [N][N];
		
		for(int i=0;i<N;i++) {
			input = br.readLine().split("");
			for(int j=0;j<N;j++) {
				a[i][j] = Integer.parseInt(input[j]);
			}
		}
		/*	
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
		*/
		go(a);
		//System.out.println("Hello Goorm! Your input is " + input);
	}
}