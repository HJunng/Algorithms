import java.util.*;
class Solution {
    static boolean[] visited;
    static char[] number;
    static HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        
        visited = new boolean[numbers.length()];
        number = new char[numbers.length()];
        
        for(int i=0;i<numbers.length();i++)
            number[i]=numbers.charAt(i);
        
        recursion("",0);
        
        
        return set.size();
    }
    public void recursion(String num, int idx){
        //System.out.println(num+" "+idx);
        //소수인지 판별.
        if(!num.equals("")){
            int n = Integer.parseInt(num);
            if(isPrime(n))
                set.add(n);
        }
        
        //끝까지 조사하면 종료.
        if(idx==number.length) return;
        
        for(int i=0;i<number.length;i++){
            if(!visited[i]){
                visited[i]=true;
                recursion(num+number[i],idx+1);
                visited[i]=false;
            }
        }
        
    }
    public boolean isPrime(int num){
        if(num==0||num==1)
            return false;
        for(int i=2;i*i<=num;i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
}