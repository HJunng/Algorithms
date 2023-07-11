package Array;

public class Lv2_연속된부분수열의합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public int[] solution(int[] sequence, int k) {
        int[] answer = {0,sequence.length-1};
        
        int sum=sequence[0];//부분수열의 합
        int left=0, right=0;
        while(true){
            if(sum<k){//부분수열 합이 k보다 작으면 right 하나 늘려줌
                if(right==sequence.length-1) break;//끝까지 갔다면 종료.
                right++;
                sum+=sequence[right];
                
            }else if(sum==k){//부분수열의 합이 k일때
                if(right-left<answer[1]-answer[0]){//더 작은 길이 저장.
                    answer[0]=left;
                    answer[1]=right;
                }
                //둘다 끝지점에 도달하면 종료
                if(right==sequence.length-1 && left==sequence.length-1){
                    break;
                }else if(right==sequence.length-1){//오른쪽만 끝지점이면 left 오른쪽으로 옮김
                    sum-=sequence[left];
                    left++;
                }else{//오른쪽으로 더 조사할 수 있으면 조사하기
                    right++;
                    sum+=sequence[right];
                }
            }else{//부분수열의 합이 k보다 크면 left값 오른쪽으로 옮김.
                sum-=sequence[left];
                left++;
            }
        }
        
        return answer;
    }
}
