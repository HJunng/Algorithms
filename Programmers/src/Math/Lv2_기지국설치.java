package Math;

public class Lv2_기지국설치 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public int solution(int n, int[] stations, int w) {
        int answer = 0;

        boolean[] spread = new boolean[n+1];//전파가 통하는 아파트

        for(int i=0;i<stations.length;i++){//전파가 통하는 아파트 저장
            for(int j=0;j<=w;j++) {
                if(stations[i]-j>0) spread[stations[i]-j]=true;//stations[i]부터 j만큼 왼쪽까지
                if(stations[i]+j<=n) spread[stations[i]+j]=true;//stations[i]부터 j만큼 오른쪽까지
            }
        }
        //전파가 안 통하는 연속된 아파트 개수
        int nonSp=0;
        for(int i=1;i<=n;i++){
            if(!spread[i]){//전파가 통하지 않는 아파트 개수 더하기
                nonSp++;
                continue;
            }

            //전파가 통하는 아파트를 만나면 이전까지 기지국을 몇개 더 설치해야 하는지 조사
            answer+=Math.ceil(nonSp/(2*w+1));
            nonSp=0;
        }


        return answer;
    }
}
