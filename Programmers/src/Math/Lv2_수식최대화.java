package Math;

import java.util.*;

public class Lv2_수식최대화 {
	static Map<Integer,Character> prior = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution("100-200*300-500+20");
	}
	static public long solution(String expression) {
        long answer = 0;
        String ops="";
        
        //우선순위 가짓수
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i==j) continue;
                for(int k=0;k<3;k++){
                    if(k==i || k==j) continue;
                    
                    prior.put(i,'+');
                    prior.put(j,'-');
                    prior.put(k,'*');
                    
                    long temp=Math.abs(culEx(expression));
                    //System.out.println(i+""+j+""+k+" "+temp);
                    if(temp>answer){
                        answer=temp;
                    }
                }
            }
        }
        //System.out.println(ops);
        return answer;
    }
    static long culEx(String ex){
        
        ArrayList<Long> num = new ArrayList<>();
        ArrayList<Character> op = new ArrayList<>();
        
        int idx=0;
        for(int i=0;i<ex.length();i++){
            if(ex.charAt(i)=='+' || ex.charAt(i)=='-' || ex.charAt(i)=='*'){
                op.add(ex.charAt(i));
                num.add(Long.parseLong(ex.substring(idx,i)));
                idx=i+1;
            }
        }
        num.add(Long.parseLong(ex.substring(idx,ex.length())));
        //System.out.println(num+" "+op);
        
        while(op.size()>0){
            for(int p=0;p<3;p++){
                for(int i=0;i<op.size();i++){
                    if(op.get(i)==prior.get(p)){//p우선순위의 연산자를 찾으면
                        long cul=0l;
                        if(op.get(i)=='+') cul=num.get(i)+num.get(i+1);
                        else if(op.get(i)=='-') cul=num.get(i)-num.get(i+1);
                        else cul=num.get(i)*num.get(i+1);

                        num.remove(i);num.remove(i);
                        num.add(i,cul);
                        op.remove(i);
                        i--;
                    }
                }
            }
        }
    
        return num.get(0);
    }
}
