package Silver3;

import java.io.*;
import java.util.*;

public class BJ2108_통계학 {		//120min.

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		double sum=0;
		int min= 4001;
		int max= -4001;
		int tmp;
		for(int i=0;i<N;i++) {
			tmp = Integer.parseInt(br.readLine());
			list.add(tmp);
			sum += (double)tmp;
			if(tmp>max) max=tmp;
			if(tmp<min) min=tmp;
		}
		
		Collections.sort(list);
		
		ArrayList<Integer> mode = new ArrayList<>();	//최빈값 list
		int repeat=1;
		int maxRepeat=0;
		mode.add(list.get(0));		//최빈값이 1일 경우도 있으므로 0번째 값 넣기.
		
		for(int i=1;i<N;i++) {//최빈값 구하기
			if(list.get(i-1).equals(list.get(i))) {	//반복 되면	
				repeat++;
				if(i==N-1) {	//마지막 수까지 반복되는 경우.
					if(repeat>maxRepeat) {			//기존의 최빈값보다 크면 리스트 비우고 새로추가.
						maxRepeat=repeat;
						mode.clear();
						mode.add(list.get(i));	
					}else if(repeat==maxRepeat) {	//기존의 최빈값과 같으면 리스트에 숫자만 추가.
						mode.add(list.get(i));
					}
				}
			}else {		//반복이 끝나면
				if(repeat>maxRepeat) {			//기존의 최빈값보다 크면 리스트 비우고 새로추가.
					maxRepeat=repeat;
					mode.clear();
					mode.add(list.get(i-1));	
				}else if(repeat==maxRepeat) {	//기존의 최빈값과 같으면 리스트에 숫자만 추가.
					mode.add(list.get(i-1));
				}
				repeat=1;	//숫자마다 반복값을 실행해줘야해서 초기화.
			}
		}
		//sb.append(sum/N).append("\n");		//평균-> 정수여서 평균이 음수가 나오면 버림된다.
		sb.append((int)Math.round(sum/N)).append("\n");		
		sb.append(list.get(N/2)).append("\n");	//중앙값
		
		if(mode.size()>1) 	//최빈값이 같은 수가 여러개 일때
			sb.append(mode.get(1)).append("\n");
		else
			sb.append(mode.get(0)).append("\n");
		
		sb.append(max-min);
		System.out.println(sb);
	}

}
