package Binary;

public class Lv2_2개이하로다른비트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(new long[] {2,7}));
	}
	static public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
        	
        	// 10-> 11 : 1의 자리가 0이므로 그 자리만 바꿔주면 i번째 수보다 크면서 가장 작은수
        	if(numbers[i]%2==0) {
        		answer[i]=numbers[i]+1;continue;
        	}
            String bin = Long.toString(numbers[i],2);
            System.out.print(bin+" -> ");
            StringBuilder next= new StringBuilder();
            
            long zeroIdx=bin.length();//뒤에서부터 0이 나오는 지점 찾기
            for(long j=bin.length()-1;j>=0;j--) {
            	if(bin.charAt((int) j)=='0') {
            		zeroIdx=j;break;
            	}
            }
            //뒤에서부터 가장 먼저 나온 0을 1로 바꿔준다.
            if(zeroIdx==bin.length()) {//1로만 이뤄져 있을 경우.
            	next.append("1"+bin);
            	zeroIdx=0;
            }
            else{
            	next.append(bin);
            	next.setCharAt((int)zeroIdx, '1');
            }
            System.out.print(next+" -> ");
            //zeroIdx 뒤부터 가장 가까운 1을 0으로 바꾸기
            for(int j=(int)zeroIdx+1;j<next.length();j++) {
            	if(next.charAt(j)=='1') {
            		next.setCharAt(j, '0');break;
            	}
            }
            System.out.println(next);
            answer[i]=Long.parseLong(next.toString());
            
        }
        
        return answer;
    }
}
