import java.util.*;

class Solution {
    static Map<Integer,String> dic = new HashMap<>(){{
       put(0,"0"); put(1,"1"); put(2,"2"); put(3,"3"); put(4,"4"); put(5,"5"); put(6,"6"); put(7,"7"); 
        put(8,"8"); put(9,"9"); put(10,"A"); put(11,"B"); put(12,"C"); put(13,"D"); put(14,"E"); put(15,"F"); 
    }};
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int num=0;
        String total=""; //n진법으로 튜브가 말해야하는 개수까지 말했을 때 전체 길이.
        
        while(total.length()<(t-1)*m+p){
            // String conv = Integer.toString(num++,n); //num을 n진법으로 변환.
            String conv =  convs(num,n);
            num++;
            total += conv;
        }
        
        for(int i=p-1; answer.length()<t; i+=m){
            answer += total.charAt(i);
        }
        
        return answer.toUpperCase();
    }
    // num을 n진법으로 변환
    String convs(int num, int n){
        
        String toNum = "";
        
        do{
            toNum = dic.get(num%n) + toNum;
            num /= n;
        }while(num>0);
        
        return toNum;
    }
}