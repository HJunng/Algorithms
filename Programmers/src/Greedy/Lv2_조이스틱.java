package Greedy;

public class Lv2_조이스틱 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution("JAN"));
		StringBuilder sb = new StringBuilder("AAA");

	}
	public static int solution(String name) {
        int answer = 0;
        
        String check="";
        for(int i=0;i<name.length();i++)
            check+="A";
        StringBuilder sb = new StringBuilder(check);
        
        int idx=0;
        boolean direction=true;//오른쪽으로 나가기.
        if(name.length()>1 && name.charAt(1)=='A')
            direction=false;//왼쪽으로
        
        while(!name.equals(sb.toString()) && idx<name.length()){
            if(idx!=0) answer++;
            System.out.println(idx+" "+sb);
            char ch=name.charAt(idx);
            
            if(ch-'A'>13)
                answer+='Z'-ch+1;
            else
                answer+=ch-'A';
            
            sb.setCharAt(idx,ch);
            
            if(direction) idx++;
            else{
                idx--;
                if(idx<0) idx=name.length()-1;
            }
        }
        return answer;
    }
}
