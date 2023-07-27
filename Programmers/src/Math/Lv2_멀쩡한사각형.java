package Math;

public class Lv2_멀쩡한사각형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public long solution(int w, int h) {
        long answer = 0;
        
        // y=ax+b 방정식 구하기
        double b=h;
        double a=(-h)/(double)w;
        
        //종이는 무조건 왼쪽위 에서 오른쪽 아래 끝으로 잘린다고 가정하면
        //기울기가 작아질 수 밖에 없기 때문에 x=0~1인 종이는 x=1일 때를 기준으로 생각한다.
        for(int x=1;x<=w;x++){
            answer+=(long)(a*x+b);//잘린 직각 삼각형의 왼쪽 아래 부분만 세어준다.
        }
        return answer*2;
    }
}
