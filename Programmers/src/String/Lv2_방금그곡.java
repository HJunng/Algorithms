package String;

import java.util.*;

public class Lv2_방금그곡 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        Map<String,Integer> sheet_time = new HashMap<>();//악보_재생시간
        Map<String,String> sheet_name = new HashMap<>();//악보_음악제목
        
        m=m.replaceAll("A#","H");//#없애기
        m=m.replaceAll("C#","I");
        m=m.replaceAll("D#","J");
        m=m.replaceAll("F#","K");
        m=m.replaceAll("G#","L");
        
        for(int i=0;i<musicinfos.length;i++){
            String[] info = musicinfos[i].split(",");
                               
            info[3]=info[3].replaceAll("A#","H");//#없애기
            info[3]=info[3].replaceAll("C#","I");
            info[3]=info[3].replaceAll("D#","J");
            info[3]=info[3].replaceAll("F#","K");
            info[3]=info[3].replaceAll("G#","L");
            
            int time=cntTime(info[0],info[1]);
            
            String sheet=info[3];
            while(sheet.length()<time){//시간만큼 늘리기
                sheet+=info[3];
            }
            
            sheet=sheet.substring(0,time);
            
            
            sheet_name.put(sheet, info[2]);//악보_제목
            sheet_time.put(sheet,cntTime(info[0],info[1]));//악보_재생시간 
        }
        //System.out.println(sheet_time);
        //System.out.println(sheet_name);
        
        String find=m;
        int maxTime=0;
        for(int i=0;i<m.length();i++){
            //if(i!=0) find=m.substring(i,m.length())+m.substring(0,i);//m 돌리기
            //System.out.println(find);
            
            for(String j:sheet_name.keySet()){
                if(j.contains(find) && sheet_time.get(j)>maxTime){//조건일치하고,재생시간이 더 긴 음악
                    maxTime=sheet_time.get(j);
                    answer=sheet_name.get(j);
                }
            }
        }
        if(answer.length()==0) return "(None)";
        
        return answer;
    }
    //재생 시간 구하기
    static int cntTime(String start, String end){
        
        String[] s=start.split(":");
        String[] e=end.split(":");
        
        int hours = Integer.parseInt(e[0])-Integer.parseInt(s[0]);
        int mins = Integer.parseInt(e[1])-Integer.parseInt(s[1]);
        
        return hours*60+mins;
    }
}
