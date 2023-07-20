package String;

import java.util.*;

public class Lv2_호텔대실 {
	static ArrayList<Integer> availTime = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static  public int solution(String[][] book_time) {
        int answer = 0;
        
        //예약시간이 빠른 순으로 book_time 정렬
        Arrays.sort(book_time, (s1,s2)->changeMins(s1[0])-changeMins(s2[0]));
        
        for(int i=0;i<book_time.length;i++){//예약 손님 받기
            //사용가능한 객실 번호 찾기
            int roomNum=-1;
            for(int j=0;j<availTime.size();j++){
                //손님 대실 시작 시간 >= j번째 객실 이용 가능한 시작 시간
                if(changeMins(book_time[i][0])>=availTime.get(j)){ roomNum=j;break; }     
            }
            
            //이용가능한 객실이 있으면, 이용이 끝나는시간+10분 청소가 끝나는 시간 넣어줍니다.
            if(roomNum>=0) availTime.set(roomNum,changeMins(book_time[i][1])+10);
            //이용할 수 있는 객실이 없다면 하나 추가하고 손님 받아서 넣음.
            else availTime.add(changeMins(book_time[i][1])+10);
        }
        
        return availTime.size();
    }
    // (String)시간 -> (int) 분
    static int changeMins(String time){
        
        String[] t = time.split(":");
        
        return Integer.parseInt(t[0])*60+Integer.parseInt(t[1]);
    }
}
