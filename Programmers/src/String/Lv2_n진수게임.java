package String;

public class Lv2_n진수게임 {

	public void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int num=0;
        String total="";
        
        //전체 문자열 길이를 (p가 t번 말할 수 있을 때)까지 구한다
        // ex - (2,4,2,1)
        // 0*, 1, 1*, 0, 1*, 1, 1*, 0, 0 -> *은 p번째 사람이 말한 숫자
        while(total.length()<p+m*(t-1)){
            total+=Integer.toString(num++,n).toUpperCase(); //num을 n진법으로 나타내 string에 저장.
        }
        
        int Idx=p-1;//현재 인덱스
        for(int i=0;i<t;i++)
            answer+=total.charAt(Idx+i*m);
        
        return answer;
    }
}
