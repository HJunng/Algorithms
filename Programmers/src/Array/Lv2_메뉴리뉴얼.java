package Array;

import java.util.*;
public class Lv2_메뉴리뉴얼 {
	static Map<String,Integer> map = new HashMap<>();
    static int order[][];
    static String[] Orders;
    static boolean[] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution(new String[] {"ABCFG","AC","CDE","ACDE","BCFG","ACDEH"}, new int[] {2,3,4});
	}
	static public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        Orders = orders;
        
        String allFood="";
        order = new int[orders.length][26];//orders의 알파벳 저장
        for(int i=0;i<orders.length;i++){
            allFood+=orders[i];
            for(int j=0;j<orders[i].length();j++) order[i][orders[i].charAt(j)-'A']=1;
        }
        
        char[] arr = allFood.toCharArray();
        Arrays.sort(arr);
        
        String dupFood="";//중복제거한 모든 음식 주문 내역
        for(int i=0;i<arr.length;i++){
            if(i!=arr.length-1 && arr[i]==arr[i+1]) continue;
            dupFood+=arr[i];
        }
        //System.out.println(dupFood);
        
        ArrayList<String> answerList = new ArrayList<>();//정답배열
        //만들 수 있는 음식 조합 (길이:course[i]) 만들기
        for(int i=0;i<course.length;i++){
            visited = new boolean[dupFood.length()];
            combination(dupFood,course[i],"",0);
            
            //가장 많이 주문된 코스 찾기
            int max=0;
            ArrayList<String> temp = new ArrayList<>();
            for(String j:map.keySet()){
                if(j.length()==course[i]){//course[i]길이의 코스 중 가장 많이 주문된 것 찾기.
                    if(map.get(j)>max){
                        temp.clear();temp.add(j);
                        max=map.get(j);
                    }else if(map.get(j)==max) temp.add(j);
                }
            }
            answerList.addAll(temp);
        }
        //System.out.println(map);
        Collections.sort(answerList);//오름차순 정렬
        
        answer = new String [answerList.size()];
        for(int i=0;i<answer.length;i++) answer[i]=answerList.get(i);
        
        
        return answer;
    }
    //str을 가지고 길이가 len인 문자열 조합.
    static void combination(String str, int len, String s, int depth){
        
        if(depth==len){
            cntCourse(s);
            return;
        }
        for(int i=0;i<str.length();i++){
            if(!visited[i]){
                if(s.length()!=0 && str.charAt(i)<s.charAt(s.length()-1)) continue;
                visited[i]=true;
                combination(str,len,s+str.charAt(i),depth+1);
                visited[i]=false;
            }
        }
    }
    //orders에 해당 코스가 몇 개 있는지 확인
    static void cntCourse(String c){
        
        int cnt=0;
        int len=c.length();
        for(int i=0;i<Orders.length;i++){
            boolean b=true;
            for(int j=0;j<len;j++){
                if(!Orders[i].contains(String.valueOf(c.charAt(j)))){
                    b=false;break;
                }
            }
            if(b) cnt++;
        }
        if(cnt>=2) map.put(c,cnt);
    }
}
