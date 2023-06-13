package Silver1;

import java.io.*;
public class BJ16139_인간컴퓨터상호작용 {		//60min.
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String S = br.readLine();	//주어진 문자열
		
		int q = Integer.parseInt(br.readLine());//질문 수
		int arr[][] = new int[S.length()+1][26];	//알파벳 개수만큼.
		
		for(int i=0;i<S.length();i++) {
			int n = S.charAt(i)-97;		//a의 아스키코드 값은 97.
			
			for(int j=0;j<26;j++) {
				arr[i+1][j]=arr[i][j];	//누적합.
			}
			arr[i+1][n]+=1;	//해당 자리의 알파벳만 +1.
		}
		
		for(int i=0;i<q;i++) {
			String str[] = br.readLine().split(" ");
			int start = Integer.parseInt(str[1]);
			int end = Integer.parseInt(str[2]);
			
			int n = str[0].charAt(0)-97;
			sb.append(arr[end+1][n]-arr[start][n]).append("\n");
			//end+1의 누적합에서 start의 누적합 뺌.
		}
		System.out.println(sb);
		
		//char str = 'a';
		//if(str==97) System.out.println(str);
		//System.out.println(++str);	//++str은 문자 출력됨.
										//str+1은 숫자 출력됨.	
	}
}