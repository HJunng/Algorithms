import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
        
        answer = makeCorrectString(p);
        
        
        return answer;
    }
    String makeCorrectString(String w){
        
        if(w.length()==0) return w;
        
        //w를 "균형잡힌 괄호 문자열" u,v로 분리
        int idx,open,close;
        idx=open=close=0;
        for(int i=0;i<w.length();i++){
            if(w.charAt(i)=='(') open++;
            else close++;
            
            if(open==close){ idx=i;break;}
        }
        String u = w.substring(0,idx+1);
        String v = w.substring(idx+1,w.length());
        
        System.out.println(u+" "+v);
        
        //u가 올바른 문자열이면
        if(isCorrect(u)) return u+makeCorrectString(v);
        
        //u가 올바른 문자열이 아니라면
        String temp="(";
        temp+=makeCorrectString(v);
        temp+=")";
        u=u.substring(1,u.length()-1);
        for(int i=0;i<u.length();i++){
            if(u.charAt(i)=='(') temp+=')';
            else temp+='(';
        }
        return temp;
    }
    boolean isCorrect(String u){
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<u.length();i++){
            if(u.charAt(i)=='(') stack.push('(');
            else{
                if(stack.isEmpty()){ stack.push(')'); break;}//비어있는데 꺼내려고 할 때
                else stack.pop();
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}