package Math;

public class Lv2_숫자블록 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end-begin+1)]; // begin~end까지 공간 만들어줌.
        
        int index=0;//answer 인덱스 번호
        for(long i=begin;i<=end;i++){ // i에서 begin~end까지의 자리를 하나씩 계산합니다.
                            //begin과 end가 long형으로 들어왔으므로 i도 long형으로 선언.
            for(int j=1;j*j<=i;j++){//약수를 구할 범위를 i의 제곱근까지만.
                if(i%j==0){//i가 j로 나눠떨어질 때
                    //기본적으로 i/j가 i보다 크기 때문에 i/j가 최종 블록이 되지만,
                    //조건에 블럭 범위가 10,000,000을 넘으면 안되고 자기자신이면 안된다는 조건에 의해
                    //else로 넘어가는 경우가 있습니다.
                    //그럴 때는 j보다 더 큰 값이 있을 수도 있기 때문에 break를 하지 않고
                    //다음 i/j, j를 더 구해봅니다.
                    
                    
                    if(i/j<=10000000 && i/j!=i){//i/j가 블록 범위를 벗어나지 않고, 자기자신이 아니면
                        answer[index]=(int)(i/j);break;//int형으로 바꿔 answer에 넣어주고, break -> 이게 약수 중에 가장 큰 수 
                    }else if(j!=i){// i/j 블록을 사용할 수 없다면
                        answer[index]=j; //자기자신이 아닌 j를 넣고 더 조사합니다.
                    }
                }
            }
            index++;//다음 자리
        }
        
        
        return answer;
    }
}
