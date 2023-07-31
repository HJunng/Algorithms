package String;

public class Lv2_문자열압축 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(String s) {
        int answer = s.length();
        
        for(int i=1;i<=s.length()/2;i++){//문자열 압축 단위
            
            String dup="";//중복 문자열
            int dupCnt=1;//중복 count
            String comp="";//압축 문자열 : s를 i단위로 압축
            
            int j=0;//s문자열에서 j번째부터 j+i번째문자까지 자름.
            for(j=0;j+i<=s.length();j+=i){
                
                if(s.substring(j,j+i).equals(dup)){//기존의 중복문자열과 같으면 
                    dupCnt++;                       //중복 count+1
                    
                }else{//기존의 중복문자열과 다르면
                    if(dupCnt>1) comp+=dupCnt+dup;//중복 개수+중복문자열
                    else comp+=dup;//중복개수가 1개면 압축 x -> 이전 문자열만 입력
                    
                    dupCnt=1;//중복 개수 초기화
                    dup=s.substring(j,j+i);//다움 문자열 중복 검사를 위해 dup에 넣어줌.
                }
            }
            //마지막에 중복 문자열 저장만 되고 나오기 때문에
            //마지막 문자열 comp에 넣어줌.
            if(dupCnt>1) comp+=dupCnt+dup;
            else comp+=dup;
            
            //문자열 s가 압축단위(i)로 나눠떨어지지 않아
            //문자열이 남는 경우
            //ex - abab abab cc (압축단위:4)
            comp+=s.substring(j,s.length());
            
            //기존보다 문자열길이가 작으면 저장.
            if(comp.length()<answer) answer=comp.length();
        }
        
        return answer;
    }
}
