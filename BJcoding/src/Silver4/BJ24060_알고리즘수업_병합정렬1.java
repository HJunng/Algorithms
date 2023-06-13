package Silver4;

import java.io.*;
import java.util.ArrayList;

public class BJ24060_알고리즘수업_병합정렬1 {
	public static int num=0;
	public static int A[];
	public static int temp[];
	public static int N;
	public static ArrayList<Integer> list;
	
	public static void merge_sort(int A[], int p, int r) {	//배열, p=배열의 첫번째 수, r = 배열의 마지막 수
		
		if(p<r) {
			int q = (p+r)/2;
			merge_sort(A, p, q);	//전반부 정렬
			merge_sort(A,q+1,r);	//후반부 정렬
			merge(A, p, q, r);		//병합
		}
	}
	public static void merge(int A[], int p, int q, int r) {
	
		int i= p;		//전반부 첫번째
		int j = q+1;	//후반부 첫번째
		int t = 0;
		while(i<=q && j<=r) {//전반부배열과 후반부배열이 둘다 정렬이 안끝난 경우.
		// ■□□□□□  ■□□□□□ 전반 후반 배열의 첫번째 수 비교해서 더 작은 값 temp에 넣기.
			if(A[i]<=A[j])  		//앞의 수가 더 작거나 같으면 그대로
				temp[t] = A[i++];
			else 
				temp[t] = A[j++];
			num++;
			list.add(temp[t]); 	//저장되는 수 저장하고 t++.
			t++;
		}
		while(i<=q) {//왼쪽 배열 부분이 남은 경우
			temp[t] = A[i++];
			list.add(temp[t++]);
			num++;
		}
		while(j<=r) {
			temp[t] = A[j++];
			list.add(temp[t++]);
			num++;
		}
		i=p;
		t=0;
		while(i<=r)		//결과를 A배열에 저장.
			A[i++] = temp[t++];
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);		//주어진 수의 개수 N
		list = new ArrayList<>();			//저장되는 수 차례대로 저장하기
		int K = Integer.parseInt(str[1]);	//저장 횟수 K
		A = new int[N];//입력받은 수 넣기
		temp = new int [N];	//정렬되면 차례로 채워넣는 배열.
		
		str=br.readLine().split(" ");
		for(int i=0;i<N;i++)
			A[i]=Integer.parseInt(str[i]);
		
		merge_sort(A, 0, N-1);

		if(num<K)//저장횟수가 K보다 작으면
			System.out.println(-1);
		else
			System.out.println(list.get(K-1));
	}

}
